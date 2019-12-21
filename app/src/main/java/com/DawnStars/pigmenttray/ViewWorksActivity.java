package com.DawnStars.pigmenttray;

import android.app.Activity;
import android.os.Bundle;

/*
 * 浏览相册照片
 * 对应Adobe XD原型“作品展示”、“作品展示 - 具体信息”和“幻灯片展示”界面
 *
 * 点击右上方按钮显示照片具体信息
 * 在下方提供幻灯片播放、分享和美颜功能的入口
 * 点击美颜功能将对应照片传递给PhotoBeautyActivity
 */
public class ViewWorksActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_works);
    }
}
