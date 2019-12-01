package com.lavamancer.articles.controller;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.lavamancer.articles.R;
import com.lavamancer.articles.model.Post;
import java.util.List;


public class PostAdapter extends BaseAdapter {

    List<Post> list;
    Activity activity;


    public static class Holder {
        private TextView dateTextView;
        private TextView titleTextView;
        private TextView authorTextView;
        private TextView bodyTextView;
    }


    public PostAdapter(Activity activity, List<Post> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(i);
        }
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;

        if (view == null) {
            view = LayoutInflater.from(activity).inflate(R.layout.item_article, viewGroup, false);
            holder = new Holder();
            holder.titleTextView = view.findViewById(R.id.titleTextView);
            holder.authorTextView = view.findViewById(R.id.authorTextView);
            holder.dateTextView = view.findViewById(R.id.dateTextView);
            holder.bodyTextView = view.findViewById(R.id.bodyTextView);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }

        Post post = list.get(i);
        holder.titleTextView.setText(post.getTitle());
        holder.authorTextView.setText("User: " + post.getUserId());
        holder.dateTextView.setText("Article: " + post.getId());
        holder.bodyTextView.setText(post.getBody());

        return view;
    }

}
