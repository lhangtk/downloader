package com.iflytek.downloader.event;


/**
 * Created by hangli2 on 2015/3/23.
 */
public class BaseEvents {

    private Object data;

    private int type;


    public Object getData() {
        return data;
    }

    public int getType() {
        return type;
    }

    public BaseEvents(int type) {
        super();
        this.type = type;
    }

    public BaseEvents(int type, Object data) {
        super();
        this.type = type;
        this.data = data;
    }


}
