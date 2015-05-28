package com.howtoistart.howtoistart;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import models.PostsMainModel;

/**
 * Created by tasol on 28/11/14.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    PostsActivity postsActivity;
    ArrayList<PostsMainModel.Post> posts;

    public MyAdapter(PostsActivity postsActivity, ArrayList<PostsMainModel.Post> posts) {
        this.postsActivity = postsActivity;
        this.posts = posts;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textview_title;
        private final TextView textview_description;
        private final TextView textview_posted_by;
        private final TextView textview_time;
        // each data item is just a string in this case

        public ViewHolder(View v) {
            super(v);
            textview_title = (TextView) v.findViewById(R.id.textview_title);
            textview_description = (TextView) v.findViewById(R.id.textview_description);
            textview_posted_by = (TextView) v.findViewById(R.id.textview_posted_by);
            textview_time = (TextView) v.findViewById(R.id.textview_time);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }
    }


    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    String getProperDate(String modified) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date oldDate =                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               null;
        try {
            oldDate = formatter.parse(modified);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long oldMillis = oldDate.getTime();
        return DateUtils.getRelativeTimeSpanString(postsActivity, oldDate.getTime()).toString();
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textview_title.setText(posts.get(holder.getPosition()).getTitle());
        holder.textview_description.setText(Html.fromHtml(posts.get(holder.getPosition()).getExcerpt()));
        holder.textview_posted_by.setText(posts.get(holder.getPosition()).getAuthor().get(0).getName());
        holder.textview_time.setText(getProperDate(posts.get(holder.getPosition()).getModified()));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return posts.size();
    }
}