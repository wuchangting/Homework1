package com.example.homework1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.jauker.widget.BadgeView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Message> messageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        messageList = new ArrayList<>();

        init();
        Button button = findViewById(R.id.messageBtn);
        BadgeView badgeView = new BadgeView(this);
        badgeView.setTargetView(button);
        //设置相对位置
        badgeView.setBadgeMargin(0, 5, 15, 0);
        //设置显示未读消息条数
        badgeView.setBadgeCount(10);



    }
    public void init(){
        Message message1 = new Message(R.drawable.baseline_bedtime_24,"月亮集团","hello");
        Message message2 = new Message(R.drawable.baseline_account_box_24,"大大老师","报告写完了吗");
        messageList.add(message1);
        messageList.add(message2);
        for(int i = 1;i <= 20;i++){
            messageList.add(new Message(R.drawable.baseline_adb_24,"无名氏"+i,"他很高冷，什么也没说"));
        }

        //添加监听器，实现上拉效果
//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//            }
//        });

        //实现接口
        MyAdapter adapter = new MyAdapter(messageList, new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(), activity_jump.class);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);
        //定义item的显示方式，是最后必要的步骤。否则，列表中数据不会显示
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
    }
}