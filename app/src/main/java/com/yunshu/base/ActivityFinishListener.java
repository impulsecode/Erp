package com.yunshu.base;

import java.util.EventListener;

/**
 * Created by Administrator on 2018/5/18.
 */

public interface ActivityFinishListener extends EventListener {

    void onFinish(ActivityFinishEvent finishEvent);
}