package com.yunshu.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.yunshu.base.BaseApplication;

/**
 * Created by Administrator on 2018/5/18.
 */

@SuppressLint("AppCompatCustomView")
public class Label extends TextView {

    public Label(Context context) {
        super(context);
        this.init();
    }

    public Label(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public Label(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.init();
    }

    private void init() {
        this.setTypeface(BaseApplication.typeFaceGlobal);
    }

    @Override
    public void setPressed(boolean pressed) {
        if (pressed && ((View) getParent()).isPressed()) {
            return;
        }
        super.setPressed(pressed);
    }
}