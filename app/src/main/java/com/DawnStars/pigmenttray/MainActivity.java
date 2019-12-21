package com.DawnStars.pigmenttray;

import android.app.Activity;
import android.os.Bundle;

/*
 * 显示最近的美化作品，并提供相册入口
 * 对应Adobe XD原型“欢迎界面”和“主界面”
 *
 * 点击上方的彩色区域跳转至AlbumActivity
 * 点击下方的照片跳转至对应照片的ViewWorksActivity
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
