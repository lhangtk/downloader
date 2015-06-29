package com.iflytek.downloader;

/**
 * 下载配置，这里主要配置不常改变的变量
 *
 * Created by hangli2 on 2015/5/6.
 */
public class DownloadConfig {

//    private String downloadSavePath;//下载文件保存路径
    /**最大下载任务数*/
    private int maxThread;
    /**失败重试次数*/
    private int retryTime;
    /**超时时间*/
    private int timeOut;

    private static DownloadConfig downloadConfig = null;
    //使用单例模式创建DownloadConfig类
    private DownloadConfig() {
        //默认配置
//        downloadSavePath = Environment.getExternalStorageDirectory().getPath()+"/download/";
//        File savePath = new File(downloadSavePath);
//        if (!savePath.exists()){
//            savePath.mkdirs();
//        }
        maxThread = 2;
        retryTime = 5;
        timeOut = 30000;//默认超时时间为3秒
    }

    public static DownloadConfig getInstance(){
        if(downloadConfig == null){
            downloadConfig = new DownloadConfig();
        }
        return downloadConfig;
    }

//    public String getDownloadSavePath() {
//        return downloadSavePath;
//    }
//
//    public void setDownloadSavePath(String downloadSavePath) {
//        this.downloadSavePath = downloadSavePath;
//        File savePath = new File(downloadSavePath);
//        if (!savePath.exists()){
//            savePath.mkdirs();
//        }
//    }


    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public int getMaxThread() {
        return maxThread;
    }

    public void setMaxThread(int maxThread) {
        this.maxThread = maxThread;
    }

    public int getRetryTime() {
        return retryTime;
    }

    public void setRetryTime(int retryTime) {
        this.retryTime = retryTime;
    }
}
