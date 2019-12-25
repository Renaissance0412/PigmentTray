package com.DawnStars.pigmenttray;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

/*
 * 浏览相册照片
 * 对应Adobe XD原型“作品展示”、“作品展示 - 具体信息”和“幻灯片展示”界面
 *
 * 点击右上方按钮显示照片具体信息
 * 在下方提供幻灯片播放、分享和美颜功能的入口
 * 点击美颜功能将对应照片传递给PhotoBeautyActivity
 */
public class ViewWorksActivity extends Activity {

    public String imagepath="imagepath";
    public String message=" ";
    //调用系统相册-选择图片
    private static final int IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_works);
        Intent intent=getIntent();
        imagepath = intent.getStringExtra("imagepath");
        message = intent.getStringExtra("message");
    }
    public void onClick(View v) {
        //调用相册
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //获取图片路径
        if (requestCode == IMAGE && resultCode == Activity.RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            String[] filePathColumns = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePathColumns[0]);
            String imagePath = c.getString(columnIndex);
            if(imagepath!=imagePath)
                message=" ";
            Intent intent = new Intent(this, ViewPhotoActivity.class);
            intent.putExtra("imagepath", imagePath);
            intent.putExtra("message", message);
            startActivity(intent);
            c.close();
        }
    }
}