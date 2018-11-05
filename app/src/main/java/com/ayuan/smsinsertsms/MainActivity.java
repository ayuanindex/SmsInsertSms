package com.ayuan.smsinsertsms;

import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button in = (Button) findViewById(R.id.btn_insert);
        //点击按钮插入一条短信
        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //由于短息数据库已经通过内容提供者暴露出来了
                Uri parse = Uri.parse("content://sms");
                ContentValues contentValues = new ContentValues();
                contentValues.put("address", "1515151");
                contentValues.put("body", "您的余额有点多");
                contentValues.put("date", System.currentTimeMillis());
                Uri uri = getContentResolver().insert(parse, contentValues);
                Log.i(TAG, "insert:" + uri);
            }
        });
    }
}
