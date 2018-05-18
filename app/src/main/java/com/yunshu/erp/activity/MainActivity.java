package com.yunshu.erp.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.yunshu.base.BaseFragment;
import com.yunshu.base.BaseFragmentActivity;
import com.yunshu.erp.R;
import com.yunshu.widget.MenuButton;

/**
 * Created by Huang secan on 2018/5/18.
 */

public class MainActivity extends BaseFragmentActivity implements MenuButton.OnMenuTabClickListener {

    private int currentIndex;

    private FragmentManager fragmentManager;

    private int[] menuButtonIdArray = new int[] { R.id.menu_button_home, R.id.menu_button_message, R.id.menu_button_my };

    private MenuButton[] MenuButtonArray = new MenuButton[3];

    private int[] fragmentIdArray = new int[] { R.id.fragment_home, R.id.fragment_message, R.id.fragment_my };

    private BaseFragment[] FragmentArray = new BaseFragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @SuppressLint("Recycle")
    private void init() {

        this.fragmentManager = getSupportFragmentManager();

        for(int i = 0; i < menuButtonIdArray.length; i++) {
            int menuButtonId = menuButtonIdArray[i];
            MenuButton menuTabButton = this.findViewById(menuButtonId);
            menuTabButton.setOnMenuTabClickListener(this);
            MenuButtonArray[i] = menuTabButton;
        }

        for(int i = 0; i < fragmentIdArray.length; i++) {
            int fragmentId = fragmentIdArray[i];
            BaseFragment fragment = (BaseFragment)this.fragmentManager.findFragmentById(fragmentId);
            fragment.fragmentIndex = i;
            FragmentArray[i] = fragment;
        }

        this.fragmentChange(0);
    }

    private void fragmentChange(int index) {

        FragmentTransaction transaction = this.fragmentManager.beginTransaction();

        for(int i = 0; i < MenuButtonArray.length; i++) {
            MenuButton menuButton = MenuButtonArray[i];
            if(i == index) {
                menuButton.setSelected();
            } else {
                menuButton.setUnSelected();
            }
        }

        for(int i = 0; i < FragmentArray.length; i++) {
            BaseFragment fragment = this.FragmentArray[i];
            if(i == index) {
                transaction.show(fragment);
                fragment.setActive(true);
            } else {
                transaction.hide(fragment);
                fragment.setActive(false);
            }
        }

        transaction.commit();
        currentIndex = index;
    }

    @Override
    public void onMenuTabClick(MenuButton menuTabButton, int index) {
        this.fragmentChange(index);
    }
}
