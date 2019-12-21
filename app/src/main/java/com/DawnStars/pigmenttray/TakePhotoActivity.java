package com.DawnStars.pigmenttray;

import android.app.Activity;
import android.os.Bundle;

/*
 * 照相界面
 * 对应Adobe XD原型“相机”和“照片选项”界面
 *
 * 点击美颜按钮将照片传递给PhotoBeautyActivity
 */
public class TakePhotoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_photo);
    }
}
