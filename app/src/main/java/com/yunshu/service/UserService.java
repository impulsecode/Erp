package com.yunshu.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.yunshu.config.PreferenceConstant;
import com.yunshu.erp.activity.LoginActivity;
import com.yunshu.utils.PreferenceUtils;
import com.yunshu.utils.ToastUtils;

/**
 * Created by Administrator on 2018/5/18.
 */

public class UserService {

    public void startLoginActivity(Activity activity, int requestCode) {
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivityForResult(intent, requestCode);
    }


    public boolean loginValidate(Context context,int requestCode) {

        if(this.getLogined(context)) {
            return true;
        }

        this.startLoginActivity((Activity) context, requestCode);
        ToastUtils.showShort(context, "请先登录");
        return false;
    }

    public boolean getLogined(Context context) {
        String userId = PreferenceUtils.getPrefString(context, PreferenceConstant.UserId, "");
        return !TextUtils.isEmpty(userId);
    }



}
