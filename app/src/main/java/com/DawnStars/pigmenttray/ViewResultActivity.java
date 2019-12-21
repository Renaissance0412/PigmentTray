package com.DawnStars.pigmenttray;

import android.app.Activity;
import android.os.Bundle;

/*
 * 查看美颜结果界面
 * 对应Adobe XD原型[美颜操作结果]系列界面
 *
 * 调用时首先获取传入的照片
 * 照片为单张时，参考“结果”
 * 照片为复数张时，参考“批量一键美颜结果”
 * 可以对照片添加描述
 * 点击确定按钮后将照片保存到本地
 */
public class ViewResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_result);
    }
}
