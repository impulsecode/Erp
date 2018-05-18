package com.yunshu.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yunshu.base.BaseApplication;
import com.yunshu.erp.R;
import com.yunshu.utils.TextUtils;

/**
 * Created by Administrator on 2018/5/18.
 */

public class MenuButton extends FrameLayout {

    private Context context;

    private AttributeSet attrs;

    private LinearLayout linearLayoutButton;

    private ImageView imageViewIcon;

    private ImageView imageViewTip;

    private TextView textViewText;

    private OnMenuTabClickListener onMenuTabClickListener;

    public boolean onSelected = false;

    private static final int colorFontDefault = Color.parseColor("#757575");

    private static final int colorFontSelected = Color.parseColor("#1296db");

    private int index;

    private int iconDefault;

    private int iconSelected;

    public MenuButton(Context context) {
        super(context);
        this.context = context;
        this.init();
    }

    public MenuButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attrs = attrs;
        this.init();
    }

    public MenuButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        this.attrs = attrs;
        this.init();
    }

    @SuppressLint("Recycle")
    private void init() {
        LayoutInflater.from(context).inflate(R.layout.control_menu_tab_button, this);

        this.linearLayoutButton = this.findViewById(R.id.menu_button);
        this.textViewText = this.findViewById(R.id.menu_button_text);
        this.textViewText.setTypeface(BaseApplication.typeFaceGlobal);
        this.textViewText.setTextColor(Color.parseColor("#757575"));
        this.imageViewIcon = this.findViewById(R.id.menu_button_icon);
        this.imageViewTip =  this.findViewById(R.id.menu_button_tip);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MenuButton);
        if(typedArray != null) {
            String text = typedArray.getString(R.styleable.MenuButton_menuButtonText);
            if(!TextUtils.isEmpty(text)) {
                this.textViewText.setText(text);
            }
            this.index = typedArray.getInt(R.styleable.MenuButton_menuButtonIndex, 0);
            this.iconDefault = typedArray.getResourceId(R.styleable.MenuButton_menuButtonDefault, R.drawable.icon_menu_home);
            this.iconSelected = typedArray.getResourceId(R.styleable.MenuButton_menuButtonSelected, R.drawable.icon_menu_home_selected);
            this.imageViewIcon.setImageResource(this.iconDefault);
        }

        this.linearLayoutButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!onSelected) {
                    MenuButton.this.setSelected();
                    if(MenuButton.this.onMenuTabClickListener != null) {
                        MenuButton.this.onMenuTabClickListener.onMenuTabClick(MenuButton.this, MenuButton.this.index);
                    }
                }
            }
        });
    }

    public void setMark(boolean mark) {
        this.imageViewTip.setVisibility(mark ? View.VISIBLE : View.GONE);
    }

    @SuppressWarnings("static-access")
    public void setSelected() {
        this.onSelected = true;
        this.textViewText.setTextColor(this.colorFontSelected);
        this.imageViewIcon.setImageResource(this.iconSelected);
    }

    @SuppressWarnings("static-access")
    public void setUnSelected() {
        this.onSelected = false;
        this.textViewText.setTextColor(this.colorFontDefault);
        this.imageViewIcon.setImageResource(this.iconDefault);
    }

    public interface OnMenuTabClickListener {
        void onMenuTabClick(MenuButton menuTabButton, int index);
    }

    public void setOnMenuTabClickListener(OnMenuTabClickListener onMenuTabClickListener) {
        this.onMenuTabClickListener = onMenuTabClickListener;
    }
}