package com.yunshu.base;

import android.app.Application;
import android.graphics.Typeface;
import org.xutils.x;

/**
 * Created by Administrator on 2018/5/18.
 */

public class BaseApplication extends Application {

    public static Typeface typeFaceGlobal;

    @Override
    public void onCreate() {
        super.onCreate();
        //设置全局字体
        BaseApplication.typeFaceGlobal = Typeface.createFromAsset(BaseApplication.this.getAssets(),"fonts/font_yahei.ttf");
        x.Ext.init(this);
    }
}
