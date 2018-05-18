package com.yunshu.base;

import android.app.Activity;
import android.content.Intent;

import java.util.EventObject;

/**
 * Created by Administrator on 2018/5/18.
 */

public class ActivityFinishEvent extends EventObject {

    private static final long serialVersionUID = 1L;

    public Activity activity;

    public int requestCode;

    public	int resultCode;

    public Intent data;

    public ActivityFinishEvent(Activity source, int requestCode, int resultCode, Intent data) {
        super(source);
        this.requestCode = requestCode;
        this.resultCode = resultCode;
        this.activity = source;
        this.data = data;
    }

    @Override
    public Object getSource(){
        return this.activity;
    }
}
