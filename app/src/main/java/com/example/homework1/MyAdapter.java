package com.example.homework1;

import static androidx.core.content.ContextCompat.startActivity;
import static java.security.AccessController.getContext;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    //存储数据
    private OnItemClickListener listener;
    private List<Message> messageList = null;

    public MyAdapter(List<Message> messageList,OnItemClickListener listener) {
        this.messageList = messageList;
        this.listener = listener;
    }

    //适配item中的控件
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //将item打拼成View
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    //显示item,将数据与item控件绑定
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Message message = messageList.get(position);
        holder.usernameText.setText(message.getUsername());
        holder.messageText.setText(message.getInform());
        holder.imageView.setImageResource(message.getImageId());

        /*
         该方法返回的是当前 item 在 RecyclerView 中的位置.
         如果 item 还没有被绑定到 RecyclerView 中，则返回 RecyclerView.NO_POSITION 常量。
         这个方法与 getBindingAdapterPosition() 方法类似，但是不会考虑 RecyclerView 中 item 的布局状态。
         */
        int itemPosition = holder.getLayoutPosition();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v,itemPosition);
            }
        });
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        holder.timeText.setText(simpleDateFormat.format(date).toString());

    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView usernameText;
        TextView messageText;
        TextView timeText;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.usernameText = itemView.findViewById(R.id.username);
            this.messageText = itemView.findViewById(R.id.message);
            this.imageView = itemView.findViewById(R.id.image);
            this.timeText = itemView.findViewById(R.id.timeView);
        }
    }

}
