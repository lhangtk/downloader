package com.iflytek.downloader;

import com.iflytek.downloader.event.DownloadEvents;
import com.iflytek.downloader.event.EventsConfig;
import com.iflytek.downloader.util.FileUtil;
import de.greenrobot.event.EventBus;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 完成下载过程的类
 *
 * Created by hangli2 on 2015/5/6.
 */
public class DownloadCore extends Thread{

        // 100 kb
        private static final long REFRESH_INTEVAL_SIZE = 100 * 1024;
        private DownloadTask task;

        // already try times
        private int tryTimes;

        private volatile boolean pauseFlag;
        public volatile boolean stopFlag;

        private String filePath;

        DownloadCore(DownloadTask task) {
            this.task = task;
            this.tryTimes = DownloadConfig.getInstance().getRetryTime();
        }

        void pauseDownload() {
            if (pauseFlag) {
                return;
            }
            pauseFlag = true;
        }

        void resumeDownload() {
            if (!pauseFlag) {
                return;
            }
            pauseFlag = false;
            synchronized (this) {
                notify();
            }
        }

        void cancelDownload() {
            stopFlag = true;

            resumeDownload();
        }

        @Override
        public void run() {
            do {
                RandomAccessFile raf = null;
                HttpURLConnection conn = null;
                InputStream is = null;
                try {
                    raf = buildDownloadFile();
                    conn = initConnection();

                    conn.connect();

//                    task.setFileSavePath(filePath);
                    if (task.getTotalSize() == 0) {
                        task.setTotalSize(conn.getContentLength());
                    }
//                    if (TextUtils.isEmpty(task.getMimeType())) {
//                        task.setMimeType(conn.getContentType());
//                    }

                    is = conn.getInputStream();

                    byte[] buffer = new byte[1024*1024];
                    int count = 0;
                    long current = task.getCurrentSize();
                    long prevTime = System.currentTimeMillis();
                    long achieveSize = current;
                    while (!stopFlag && (count = is.read(buffer)) != -1) {
                        while (pauseFlag) {
//                            manager.onDownloadPaused(task);
                            synchronized (this) {
                                try {
                                    wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
//                                    manager.onDownloadResumed(task);
                                }
                            }
                        }

                        raf.write(buffer, 0, count);
                        current += count;

                        long tempSize = current - achieveSize;
                        if (tempSize > REFRESH_INTEVAL_SIZE) {
                            long tempTime = System.currentTimeMillis() - prevTime;
                            long speed = tempSize * 1000 / tempTime;
                            achieveSize = current;
                            prevTime = System.currentTimeMillis();
                            task.setCurrentSize(current);
                            task.setSpeed(speed);
//                            manager.onUpdateDownloadTask(task);
                            EventBus.getDefault().post(new DownloadEvents(EventsConfig.DOWNLOAD_UPDATE,task));
//                            MyBroadcast.getLocalBroadcastManager().sendBroadcast(new Intent("Action"));
                        }
                    }
                    //关闭流
                    is.close();
                    task.setCurrentSize(current);

                    if (stopFlag) {
//                        manager.onDownloadCanceled(task);
                    } else {
//                        manager.onDownloadSuccessed(task);
                        EventBus.getDefault().post(new DownloadEvents(EventsConfig.DOWNLOAD_SUCCESS,task));
                    }
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                    if (tryTimes > DownloadConfig.getInstance().getRetryTime()) {
//                        manager.onDownloadFailed(task);
                        EventBus.getDefault().post(new DownloadEvents(EventsConfig.DOWNLOAD_FAILURE,task));
                        break;
                    } else {
                        tryTimes++;
                        continue;
                    }
                }
            } while (true);
        }

        private RandomAccessFile buildDownloadFile() throws IOException {
            String fileName;
            if (task.getFileName() != null) {
                fileName = task.getFileName();
            }else{
                fileName = FileUtil.getFileNameByUrl(task.getUrl());
            }
            String fileSavePath = task.getFileSavePath();
            File file = new File(fileSavePath);
            if (!file.exists()){
                file.mkdirs();
            }
//            if (file.isDirectory()) {
                file = new File(fileSavePath+"/"+fileName);
//            } else if (file.isFile()) {
                // 不用处理
//            }
//            else {
//                file = new File(DownloadConfig.getInstance().getDownloadSavePath(), fileName);
//            }
//            if (!file.getParentFile().isDirectory() && !file.getParentFile().mkdirs()) {
//                throw new IOException("cannot create download folder");
//            }
            filePath = file.getAbsolutePath();
            if (file.exists() && task.getCurrentSize() == 0) {// 文件存在，但是已下载大小为0，说明文件和下载信息不配置，删除文件，重新下载
                file.delete();
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            if (task.getCurrentSize() != 0) {
                raf.seek(task.getCurrentSize());
            }
            return raf;
        }

    /**
     * 初始化下载connection
     * @return
     * @throws IOException
     */
        private HttpURLConnection initConnection() throws IOException {
            HttpURLConnection conn = (HttpURLConnection) new URL(task.getUrl()).openConnection();
            conn.setConnectTimeout(DownloadConfig.getInstance().getTimeOut());
            conn.setReadTimeout(DownloadConfig.getInstance().getTimeOut());
            conn.setUseCaches(true);
            if (task.getCurrentSize() != 0) {
                conn.setRequestProperty("Range", "bytes=" + task.getCurrentSize() + "-");
            }

            return conn;
        }


}
