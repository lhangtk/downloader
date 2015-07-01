package com.iflytek.downloader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hangli2 on 2015/5/6.
 */
public class DownloadManager {
    private ExecutorService pool;
    public DownloadManager(){
        pool = Executors.newFixedThreadPool(DownloadConfig.getInstance().getMaxThread());
    }

    public void addTask(DownloadTask task){
//        if (task.getDownloadCore().stopFlag){
//            task.setDownloadCore(new DownloadCore(task));
//        }
        task.reCreateTask();
        pool.submit(task.getDownloadCore());
    }

    public void resume(DownloadTask task){
        task.resume();
    }

    public void pause(DownloadTask task){
        task.pause();
    }

    public void cancel(DownloadTask task){
        task.cancel();
    }
}
