package com.yunshu.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yunshu.utils.TextUtils;
import com.yunshu.erp.R;


/**
 * Created by Administrator on 2018/5/18.
 */

public class IconInput extends LinearLayout {

    private Context context;

    private AttributeSet attrs;

    private ImageView imageViewIcon;

    private Label label;

    private TextBox textBox;

    private int iconId;

    private int mode;

    private String desc;

    private String inputType;

    public ITextChanged ListenerTextChanged;

    public IconInput(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public IconInput(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attrs = attrs;
        init();
    }

    public IconInput(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        this.attrs = attrs;
        init();
    }

    @SuppressLint("Recycle")
    @SuppressWarnings("deprecation")
    private void init() {
        LayoutInflater.from(context).inflate(R.layout.control_icon_input, this);

        this.imageViewIcon = this.findViewWithTag("icon_input_icon");
        this.label = this.findViewWithTag("icon_input_label");
        this.textBox = this.findViewWithTag("icon_input_textbox");

        this.textBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence sequence, int start, int before, int count) {
                String inputString = sequence.toString();

                if (TextUtils.isNullOrEmpty(inputString)) {
                    IconInput.this.label.setVisibility(View.VISIBLE);
                } else {
                    IconInput.this.label.setVisibility(View.INVISIBLE);
                }

                if(ListenerTextChanged != null) {
                    ListenerTextChanged.onTextChanged(inputString);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }

            @Override
            public void beforeTextChanged(CharSequence sequence, int start, int count, int after) {
            }
        });

        if(this.attrs != null) {

            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.IconInput);

            this.iconId = typedArray.getResourceId(R.styleable.IconInput_iconInputIcon, R.drawable.icon_username);
            this.imageViewIcon.setBackgroundDrawable(context.getResources().getDrawable(this.iconId));

            this.mode = typedArray.getInt(R.styleable.IconInput_iconInputMode, 0);
            if(this.mode == 1) {
                this.imageViewIcon.setVisibility(View.GONE);
            }

            this.desc = typedArray.getString(R.styleable.IconInput_iconInputDesc);
            if(!TextUtils.isNullOrEmpty(this.desc)) {
                this.label.setText(this.desc);
            }
            this.inputType = typedArray.getString(R.styleable.IconInput_iconInputType);
            if(!TextUtils.isNullOrEmpty(this.inputType) && this.inputType.equals("password")) {
                this.textBox.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }

        }
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.textBox.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void setInputType(int inputType) {
        this.textBox.setInputType(inputType);
    }

    public Editable getText() {
        return this.textBox.getText();
    }

    public void setText(CharSequence text) {
        this.textBox.setText(text);
    }

    public interface ITextChanged {
        public void onTextChanged(String content);
    }

}
