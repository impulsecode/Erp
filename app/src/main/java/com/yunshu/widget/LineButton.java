package com.yunshu.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.Button;

import com.yunshu.base.BaseApplication;

/**
 * Created by Administrator on 2018/5/18.
 */

@SuppressLint("AppCompatCustomView")
public class LineButton extends Button {

    public LineButton(Context context) {
        super(context);
        init();
    }

    public LineButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LineButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @SuppressLint("Recycle")
    private void init() {
        this.setGravity(Gravity.CENTER);
        this.setTypeface(BaseApplication.typeFaceGlobal);
    }
}