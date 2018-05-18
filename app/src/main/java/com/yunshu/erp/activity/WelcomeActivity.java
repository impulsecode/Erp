package com.yunshu.erp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.yunshu.base.BaseActivity;
import com.yunshu.config.IdentityRequestCode;
import com.yunshu.erp.R;
import com.yunshu.service.UserService;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

/**
 * Created by Administrator on 2018/5/18.
 */

@ContentView(R.layout.activity_welcome)
public class WelcomeActivity extends BaseActivity {

    private UserService userService;

    private TimeCount timeCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        userService = new UserService();
        this.timeCount = new TimeCount(3000, 1000);
        this.timeCount.start();
    }

    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
        }

        @Override
        public void onFinish() {
            userService.loginValidate(WelcomeActivity.this, IdentityRequestCode.Home);
        }
    }
}

