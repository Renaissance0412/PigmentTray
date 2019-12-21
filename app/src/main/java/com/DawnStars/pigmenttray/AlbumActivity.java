package com.DawnStars.pigmenttray;

import android.app.Activity;
import android.os.Bundle;

/*
 * 显示相册和照片
 * 对应Adobe XD原型“相册选择界面”、“相片选择界面”、“相片选择界面 - 多选”和“相片选择界面 - 全选”界面
 *
 * 长按选中照片后可以调用分享功能
 * 选中单张照片启动PhotoBeautyActivity
 * 选中复数张照片应对所有照片调用一键美颜功能，然后将处理好的照片传递给ViewResultActivity
 */
public class AlbumActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
    }
}
