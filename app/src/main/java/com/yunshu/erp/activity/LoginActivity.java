package com.yunshu.erp.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yunshu.base.BaseActivity;
import com.yunshu.erp.R;
import com.yunshu.utils.ToastUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Administrator on 2018/5/18.
 */

@ContentView(R.layout.activity_login)
public class LoginActivity extends BaseActivity {

    @ViewInject(R.id.button_login)
    Button buttonLogin;

    @ViewInject(R.id.button_exit)
    Button buttonExit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }

    @Event(type = View.OnClickListener.class, value = R.id.button_login)
    private void buttonLoginClick(View view) {
        ToastUtils.show(this, "12345", 500);
    }

    @Event(value = R.id.button_exit)
    private void buttonExitClick(View view) {
        ToastUtils.show(this, "54321", 500);
    }
}
