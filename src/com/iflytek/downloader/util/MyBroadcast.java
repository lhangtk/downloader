package com.iflytek.downloader.util;

import android.support.v4.content.LocalBroadcastManager;

/**
 * Created by hangli2 on 2015/6/29.
 */
public class MyBroadcast {
    private static LocalBroadcastManager localBroadcastManager;

    public static LocalBroadcastManager getLocalBroadcastManager() {
        return localBroadcastManager;
    }

    public static void setLocalBroadcastManager(LocalBroadcastManager localBroadcastManager) {
        MyBroadcast.localBroadcastManager = localBroadcastManager;
    }
}
