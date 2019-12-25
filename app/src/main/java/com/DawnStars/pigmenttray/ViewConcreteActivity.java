package com.DawnStars.pigmenttray;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewConcreteActivity extends AppCompatActivity {
    public String imagepath="imagepath";
    public String message=" ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_concrete);
        Intent intent = getIntent();
        imagepath = intent.getStringExtra("imagepath");
        message=intent.getStringExtra("message");
        Bitmap bm = BitmapFactory.decodeFile(imagepath);
        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageBitmap(bm);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);
    }

    public void displayMessage(View view) { //用编辑栏中输入的信息对文本框中的信息进行更新并显示
        EditText editText = (EditText) findViewById(R.id.editText);
        message = editText.getText().toString();
        editText.setVisibility(View.INVISIBLE);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);
    }

    public void backPhoto(View view) {  //返回ViewPhotoActivity
        Intent intent = new Intent(this, ViewPhotoActivity.class);
        intent.putExtra("imagepath",imagepath);
        intent.putExtra("message",message);
        startActivity(intent);
    }

    public void backChoose(View view) { //返回ViewWorksActivity
        Intent intent = new Intent(this, ViewWorksActivity.class);
        intent.putExtra("imagepath",imagepath);
        intent.putExtra("message",message);
        startActivity(intent);
    }

    public void toBeauty(View view) {   //进入PhotoBeautyActivity
        Intent intent = new Intent(this, PhotoBeautyActivity.class);
        intent.putExtra("imagepath",imagepath);
        intent.putExtra("message",message);
        startActivity(intent);
    }

}
