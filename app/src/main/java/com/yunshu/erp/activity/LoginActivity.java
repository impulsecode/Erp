package com.yunshu.erp.activity;

import android.os.Bundle;
import android.widget.Button;

import com.yunshu.base.BaseActivity;
import com.yunshu.erp.R;

import org.xutils.view.annotation.ContentView;
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
}
