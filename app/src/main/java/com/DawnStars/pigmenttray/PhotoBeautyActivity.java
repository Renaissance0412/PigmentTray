package com.DawnStars.pigmenttray;

import android.app.Activity;
import android.os.Bundle;

/*
 * 相片美颜的操作界面
 * 对应Adobe XD原型[美颜操作]系列界面
 *
 * 调用时首先获取传入的照片
 * 提供实时预览功能
 * 点击右上角保存按钮后将处理好的图片传递给ViewResultActivity
 */
public class PhotoBeautyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_beauty);
    }
}
