package com.org.curesoft.volleygsonrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Prabin kumar mallick on 02-04-2018.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.TestHolder> {

    Context mctx;
    User[] users;//we can pass array or list or anything from mainactivity to adapter

    public CustomAdapter(Context mctx, User[] users) {
        this.mctx = mctx;
        this.users = users;
    }

    @Override
    public TestHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       LayoutInflater inflater= LayoutInflater.from(parent.getContext());
       View view= inflater.inflate(R.layout.row_item,parent,false);//create the view and pass to viewholder
        return new TestHolder(view);
    }

    @Override
    public void onBindViewHolder(TestHolder holder, int position) {
      User user=users[position];
        holder.tv.setText(user.getLogin());
        Glide.with(holder.im.getContext()).load(user.getAvatarUrl()).into(holder.im);
    }

    @Override
    public int getItemCount() {
        return users.length;
    }

    class TestHolder extends RecyclerView.ViewHolder {
        ImageView im;
        TextView tv;
        public TestHolder(View itemView) {
            super(itemView);
            im= (ImageView) (itemView).findViewById(R.id.profile);
            tv= (TextView) (itemView).findViewById(R.id.name);

        }
    }
}
