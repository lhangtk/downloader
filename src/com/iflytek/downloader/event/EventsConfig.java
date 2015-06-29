package com.iflytek.downloader.event;

/**
 * Created by hangli2 on 2015/3/23.
 */
public class EventsConfig {

    /**下载成功*/
    public static final int DOWNLOAD_SUCCESS = 0xFFFF;
    /**下载失败*/
    public static final int DOWNLOAD_FAILURE = 0xFFFE;
    /**下载过程中传递信息*/
    public static final int DOWNLOAD_UPDATE = 0xFFFD;
    /**下载取消*/
    public static final int DOWNLOAD_CANCEL = 0xFFFC;
}
