package com.iflytek.downloader;

import java.io.File;

/**
 * 下载任务模型
 * 每个task绑定一个下载线程
 * Created by hangli2 on 2015/5/6.
 */
public class DownloadTask {
    /**标记下载任务的唯一ID*/
    private String id;
    /**下载文件名*/
    private String fileName;
    /**下载url*/
    private String url;
    /**文件保存路径*/
    private String fileSavePath ;
    /**文件总大小*/
    private long totalSize;
    /**目前已下载的大小*/
    private long currentSize;
    /**下载速度*/
    private long speed;

    private DownloadCore downloadCore;

    public DownloadTask(){
        downloadCore = new DownloadCore(this);
    }

//    public void start(){
//        downloadCore.start();
//    }

    public void pause(){
        downloadCore.pauseDownload();
    }

    public void resume(){
        downloadCore.resumeDownload();
    }

    public void cancel(){
        downloadCore.cancelDownload();
        File file = new File(fileSavePath+"/"+fileName);
        if (file.exists()){
            file.delete();
        }
    }

    public DownloadCore getDownloadCore() {
        return downloadCore;
    }

    public String getFileName() {
        return fileName;
    }

    /**
     * 设置文件名，不设置的话使用默认文件名
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public long getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(long currentSize) {
        this.currentSize = currentSize;
    }

    public String getFileSavePath() {
        return fileSavePath;
    }

    public void setFileSavePath(String fileSavePath) {
        this.fileSavePath = fileSavePath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
