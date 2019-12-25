package com.DawnStars.pigmenttray;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import java.io.File;
import java.io.FileDescriptor;

public class ViewPhotoActivity extends AppCompatActivity {
    public String imagepath="imagepath";
    public String message=" ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_photo);
        Intent intent = getIntent();
        imagepath=intent.getStringExtra("imagepath");
        message=intent.getStringExtra("message");
        Bitmap bm = getBitmapFromUri(getApplicationContext(), getImageContentUri(getApplicationContext(), imagepath));
        ImageView imageView = findViewById(R.id.image);
        imageView.setImageBitmap(bm);
    }

    public static Uri getImageContentUri(Context context, String path) {
        Cursor cursor = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[] { MediaStore.Images.Media._ID }, MediaStore.Images.Media.DATA + "=? ",
                new String[] { path }, null);
        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndex(MediaStore.MediaColumns._ID));
            Uri baseUri = Uri.parse("content://media/external/images/media");
            return Uri.withAppendedPath(baseUri, "" + id);
        } else {
            // 如果图片不在手机的共享图片数据库，就先把它插入。
            if (new File(path).exists()) {
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.DATA, path);
                return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            } else {
                return null;
            }
        }
    }

    public static Bitmap getBitmapFromUri(Context context, Uri uri) {
        try {
            ParcelFileDescriptor parcelFileDescriptor =
                    context.getContentResolver().openFileDescriptor(uri, "r");
            FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
            Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
            parcelFileDescriptor.close();
            return image;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void backChoose(View view) { //返回ViewWorksActivity
        Intent intent = new Intent(this, ViewWorksActivity.class);
        intent.putExtra("imagepath", imagepath);
        intent.putExtra("message", message);
        startActivity(intent);
    }

    public void toConcrete(View view) { //进入ViewConcreteActivity
        Intent intent = new Intent(this, ViewConcreteActivity.class);
        intent.putExtra("imagepath", imagepath);
        intent.putExtra("message", message);
        startActivity(intent);
    }

    public void toBeauty(View view) { //进入PhotoBeautyActivity
        Intent intent = new Intent(this, PhotoBeautyActivity.class);
        intent.putExtra("imagepath", imagepath);
        intent.putExtra("message", message);
        startActivity(intent);
    }
}