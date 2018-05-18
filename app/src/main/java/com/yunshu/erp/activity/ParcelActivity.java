package com.yunshu.erp.activity;

import android.annotation.SuppressLint;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yunshu.base.BaseActivity;
import com.yunshu.erp.R;

/**
 * Created by Administrator on 2018/5/18.
 */

public class ParcelActivity extends BaseActivity implements View.OnClickListener {

    private ViewGroup layoutGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcel);
        setupViews();
    }

    private void setupViews() {

        //找到该容器（这里的控件为LinearLayout，转换为ViewGroup是因为ViewGroup是容器的基类）
        layoutGroup = findViewById(R.id.layout_parcel_button_group);

        final String[] texts = { "疵品登记", "产品返修", "疵品记录", "返修记录" };
        final int[] normalImages = { R.drawable.icon_inferior_regist_normal, R.drawable.icon_repair_normal,
                R.drawable.icon_inferior_record_normal, R.drawable.icon_repair_record_normal };
        final int[] pressedImages = { R.drawable.icon_inferior_regist_pressed, R.drawable.icon_repair_pressed,
                R.drawable.icon_inferior_record_pressed, R.drawable.icon_repair_record_pressed };

        final int size = texts.length;
        final int rowCount = (int) Math.ceil(size / (double)3);


        fillViews(layoutGroup, texts, normalImages, pressedImages, 0, rowCount);
    }

    private void fillViews(ViewGroup layout, String[] texts,int[] normalImages,int[] pressedImages, int start, int end) {

        for (int i = start; i < end; i++) {

            // 父布局
            final LinearLayout linearLayout = new LinearLayout(this);

            // 第一个子布局
            final int firstIndex = i * 3;

            if(firstIndex >= texts.length) {
                return;
            }

            final String firstText = texts[firstIndex];
            final int firstDrawableNormal = normalImages[firstIndex];
            final int firstDrawablePressed = pressedImages[firstIndex];

            final StateListDrawable firstDrawable = new StateListDrawable();
            firstDrawable.addState(new int[]{android.R.attr.state_pressed}, getResources().getDrawable(firstDrawablePressed));
            firstDrawable.addState(new int[]{}, getResources().getDrawable(firstDrawableNormal));

            View.inflate(this, R.layout.layout_grid_button, linearLayout);
            View.inflate(this, R.layout.layout_line_vertical, linearLayout);

            final View firstView = linearLayout.getChildAt(0);
            firstView.setTag(firstText);        //设置tag，便于在后面判断点击的哪一个
            firstView.setOnClickListener(this);     //设置点击
            final TextView firstTextView = firstView.findViewById(R.id.grid_button_text);
            firstTextView.setText(firstText);   //设置文字
            final ImageView firstImageView = firstView.findViewById(R.id.grid_button_icon);
            firstImageView.setImageDrawable(firstDrawable); //将之前缓存的图片设置出来

            // 第二个子布局
            final int secondIndex = i * 3 + 1;

            if(secondIndex < texts.length) {
                final String secondText = texts[secondIndex];
                final int secondDrawableNormal = normalImages[secondIndex];
                final int secondDrawablePressed = pressedImages[secondIndex];

                final StateListDrawable secondDrawable = new StateListDrawable();
                secondDrawable.addState(new int[]{ android.R.attr.state_pressed }, getResources().getDrawable(secondDrawablePressed));
                secondDrawable.addState(new int[]{}, getResources().getDrawable(secondDrawableNormal));

                View.inflate(this, R.layout.layout_grid_button, linearLayout);
                View.inflate(this, R.layout.layout_line_vertical, linearLayout);

                final View secondView = linearLayout.getChildAt(2);
                secondView.setTag(secondText);
                secondView.setOnClickListener(this);
                final TextView secondTextView = secondView.findViewById(R.id.grid_button_text);
                secondTextView.setText(secondText);
                final ImageView secondImageView = secondView.findViewById(R.id.grid_button_icon);
                secondImageView.setImageDrawable(secondDrawable);
            } else {
                View.inflate(this, R.layout.layout_grid_button, linearLayout);
            }

            // 第三个子布局
            final int thirdIndex = i * 3 + 2;

            if(thirdIndex < texts.length) {
                final String thirdText = texts[thirdIndex];
                final int thirdDrawableNormal = normalImages[thirdIndex];
                final int thirdDrawablePressed = pressedImages[thirdIndex];

                final StateListDrawable thirdDrawable = new StateListDrawable();
                thirdDrawable.addState(new int[]{ android.R.attr.state_pressed }, getResources().getDrawable(thirdDrawablePressed));
                thirdDrawable.addState(new int[]{}, getResources().getDrawable(thirdDrawableNormal));

                View.inflate(this, R.layout.layout_grid_button, linearLayout);

                final View thirdView = linearLayout.getChildAt(4);
                thirdView.setTag(thirdText);
                thirdView.setOnClickListener(this);
                final TextView thirdTextView = thirdView.findViewById(R.id.grid_button_text);
                thirdTextView.setText(thirdText);
                final ImageView thirdImageView =  thirdView.findViewById(R.id.grid_button_icon);
                thirdImageView.setImageDrawable(thirdDrawable);
            } else {
                View.inflate(this, R.layout.layout_grid_button, linearLayout);
            }

            ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layout.addView(linearLayout, layoutParams);
        }
    }

    @Override
    @SuppressLint("WrongConstant")
    public void onClick(View v) {
        //通过之前setTag找到点击位置
        final Object tag = v.getTag();
        if (tag != null) {
            String department = (String) tag;
            Toast.makeText(this, department, 0).show();
        }
    }
}