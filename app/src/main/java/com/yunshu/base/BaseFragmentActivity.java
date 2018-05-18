package com.yunshu.base;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Administrator on 2018/5/18.
 */

public class BaseFragmentActivity extends FragmentActivity {

    protected int indexFragment;

    private Vector<ActivityFinishListener> finishListeners = new Vector<ActivityFinishListener>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Enumeration<ActivityFinishListener> listeners = finishListeners.elements();
        while(listeners.hasMoreElements()) {
            ActivityFinishListener listener = listeners.nextElement();
            listener.onFinish(new ActivityFinishEvent(this, requestCode, resultCode, data));
        }
    }

    public void AddFinishEvent(ActivityFinishListener listener) {
        finishListeners.add(listener);
    }



    private Vector<BroadcastReceiver> broadcastReceivers = new Vector<BroadcastReceiver>();
}
