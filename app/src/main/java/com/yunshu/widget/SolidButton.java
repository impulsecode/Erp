package com.yunshu.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.yunshu.base.BaseApplication;
import com.yunshu.erp.R;

/**
 * Created by Administrator on 2018/5/18.
 */

@SuppressLint({"ClickableViewAccessibility", "AppCompatCustomView"})
public class SolidButton extends Button {

    private Context context;

    public Drawable drawableBackground;

    public SolidButton(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public SolidButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public SolidButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        init();
    }

    @SuppressWarnings("deprecation")
    public void setDisabled() {
        this.setBackgroundDrawable(this.context.getResources().getDrawable(R.drawable.selector_button_solid_bg_disabled));
        this.setClickable(false);
    }

    @SuppressWarnings("deprecation")
    public void setEnabled() {
        this.setBackgroundDrawable(this.drawableBackground);
        this.setClickable(true);
    }

    private void init() {
        this.drawableBackground = this.getBackground();
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
