package com.yunshu.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2018/5/18.
 */

public abstract class BaseFragment extends Fragment {

    protected boolean initialized = false;

    protected boolean isActive = false;

    protected View mainView;

    public int fragmentIndex;

    protected abstract void initialize();

    protected abstract int setLayoutView();

    protected abstract void bindChildren(View view);

    protected abstract void onActive(boolean initialized);

    protected void onFragmentResume() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //   this.activity = (BaseFragmentActivity)this.getActivity();
        this.initialize();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(isActive) {
            this.onFragmentResume();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int layoutId = this.setLayoutView();
        this.mainView = inflater.inflate(layoutId, container);
        this.bindChildren(mainView);
        return this.mainView;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
        if (isActive){
            this.onActive(this.initialized);
            if(!this.initialized) {
                this.initialized = true;
            }
        }
    }
}