package com.example.homework1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class activity_jump extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump);

        TextView textView = findViewById(R.id.showText);
        Intent intent = getIntent();
        //注意目标值的数据类型，使用getStringExtra()获取的int数据为null
        int position = intent.getIntExtra("position",0)+1;
        textView.setText("我是第"+position+"个item");
    }
}
