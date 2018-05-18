package com.yunshu.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yunshu.base.BaseApplication;
import com.yunshu.erp.R;
import com.yunshu.utils.TextUtils;

/**
 * Created by Administrator on 2018/5/18.
 */

public class NavBarView extends LinearLayout {

    private Context context;

    private AttributeSet attrs;

    private String title;

    private Boolean hasBack;

    private Boolean hasGo;

    private Label labelTitle;

    public ImageView buttonBack;

    public ImageView buttonGo;

    public Integer buttonGoImg;

    private OnNavBarClickListener onNavBarClickListener;

    public NavBarView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public NavBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attrs = attrs;
        init();
    }

    public NavBarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        this.attrs = attrs;
        init();
    }

    @SuppressLint("Recycle")
    private void init() {

        LayoutInflater.from(context).inflate(R.layout.view_navbar, this);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.NavBarView);
        this.title = array.getString(R.styleable.NavBarView_navBarTitle);
        this.hasBack = array.getBoolean(R.styleable.NavBarView_navBarHasBack, false);
        this.hasGo = array.getBoolean(R.styleable.NavBarView_navBarHasGo, false);

        this.buttonGoImg = array.getResourceId(R.styleable.NavBarView_navBarGoImg, R.drawable.icon_confirm);
        this.labelTitle = this.findViewById(R.id.navbar_text_title);
        this.labelTitle.setTypeface(BaseApplication.typeFaceGlobal);
        this.buttonBack = this.findViewById(R.id.navbar_button_back);
        this.buttonGo = this.findViewById(R.id.navbar_button_go);

        if (hasBack) {
            this.buttonBack.setVisibility(View.VISIBLE);
            this.buttonBack.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    if(onNavBarClickListener != null) {
                        onNavBarClickListener.onNavBarLeftClicked();
                    }
                    ((Activity)NavBarView.this.context).finish();
                }

            });
        }

        if (hasGo) {
            this.buttonGo.setVisibility(View.VISIBLE);
            this.buttonGo.setImageResource(buttonGoImg);
            this.buttonGo.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    if(onNavBarClickListener != null) {
                        onNavBarClickListener.onNavBarRightClicked();
                    }
                }

            });
        }

        if (!TextUtils.isNullOrEmpty(this.title)) {
            this.labelTitle.setText(this.title);
        }
    }

    public void setOnNavBarClickListener(OnNavBarClickListener onNavBarClickListener) {
        this.onNavBarClickListener = onNavBarClickListener;
    }

    public interface OnNavBarClickListener {
        void onNavBarLeftClicked();
        void onNavBarRightClicked();
    }

    public void setTitle(CharSequence text) {
        this.labelTitle.setText(text);
    }
}
