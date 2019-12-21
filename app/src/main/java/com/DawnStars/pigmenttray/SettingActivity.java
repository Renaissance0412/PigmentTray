package com.DawnStars.pigmenttray;

import android.app.Activity;
import android.os.Bundle;

/*
 * 应用设置界面
 * 对应Adobe XD原型“设置”界面
 *
 * 仅作展示
 * 点击上方彩色区域跳转至AlbumActivity
 */
public class SettingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }
}
