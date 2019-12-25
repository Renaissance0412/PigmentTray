package com.DawnStars.pigmenttray;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

/*
 * 相片美颜的操作界面
 * 对应Adobe XD原型[美颜操作]系列界面
 *
 * 调用时首先获取传入的照片
 * 提供实时预览功能
 * 点击右上角保存按钮后将处理好的图片传递给ViewResultActivity
 */

public class PhotoBeautyActivity extends AppCompatActivity{

    private static class ActionPath {
        String action="";
    }   //定义操作类
    public static int index=0;  //记录正处于的图片状态在图片状态（操作）序列中的位置
    public String imagepath="imagepath";
    public String message=" ";
    public ArrayList<ActionPath> mPathStack=new ArrayList<ActionPath>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_beauty);
        Intent intent = getIntent();
        imagepath = intent.getStringExtra("imagepath");
        message = intent.getStringExtra("message");
        Bitmap bm = BitmapFactory.decodeFile(imagepath);
        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageBitmap(bm);
        ActionPath origin=new ActionPath(); //图片初始状态
        mPathStack.add(origin);   //图片初始状态加入图片状态（操作）序列
    }

    public void backPhoto(View view) {  //返回ViewPhotoActivity
        Intent intent = new Intent(this, ViewPhotoActivity.class);
        intent.putExtra("imagepath",imagepath);
        intent.putExtra("message",message);
        startActivity(intent);
    }

    public void action(View view){  //接受事件，完成一次操作
        ActionPath action=new ActionPath();
        index++;
        mPathStack.add(index,action);

    }

    public void iterate(ActionPath action){}    //撤销或重做时进行的动作

    public void back(View view) {   //撤销
        if (mPathStack.size() > 0) {
            ActionPath action=mPathStack.get(index);
            index--;
            iterate(action);
        }
    }

    public void forward(View view) {    //重做
        if (mPathStack.size() > 1) {
            ActionPath action=mPathStack.get(index);
            index++;
            iterate(action);
        }
    }
}
