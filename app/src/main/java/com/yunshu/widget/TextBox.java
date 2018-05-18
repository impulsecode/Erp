package com.yunshu.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import com.yunshu.base.BaseApplication;

/**
 * Created by Administrator on 2018/5/18.
 */

@SuppressLint("AppCompatCustomView")
public class TextBox extends EditText {

    public TextBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(BaseApplication.typeFaceGlobal);
    }

}
