package com.howtoistart.howtoistart;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import application.MyApplication;
import models.PostContentModel;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by anmol on 5/6/15.
 */
public class PostContentFragment extends ActionBarActivity {

    private String post_id;
    MyApplication application;

    private Toolbar toolbar;
    private SwipeRefreshLayout refresh_layout;
    private ImageView postImage;
    private LinearLayout linearLayout;
    private TextView textviewTitle;
    private TextView textviewTime;
    private TextView textviewPostedBy;
    private TextView textviewContentPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_post_contentactivity);
        findViews();
        post_id = getIntent().getStringExtra("id");
        application = (MyApplication) this.getApplication();
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("wpapi", "get_posts");
                params.put("dev", "1");
                params.put("id", "" + post_id);
                params.put("content", "" + 1);
                refresh_layout.setRefreshing(true);
                application.getService().getPostDetail(params, new Callback<PostContentModel>() {
                    @Override
                    public void success(PostContentModel postContentModel, Response response) {
                        refresh_layout.setRefreshing(false);
                        textviewContentPost.setText(Html.fromHtml(postContentModel.getPosts().get(0).getContent()));
                        textviewTitle.setText(Html.fromHtml(postContentModel.getPosts().get(0).getTitle()));

                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        Date oldDate = null;
                        try {
                            oldDate = formatter.parse(postContentModel.getPosts().get(0).getModified());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        long oldMillis = oldDate.getTime();
                        textviewTime.setText(DateUtils.getRelativeTimeSpanString(PostContentFragment.this, oldDate.getTime()).toString());
                        textviewPostedBy.setText(postContentModel.getPosts().get(0).getAuthor().get(0).getName());
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        refresh_layout.setRefreshing(false);
                    }
                });

            }
        }, 500);


    }


    private void findViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        refresh_layout = (SwipeRefreshLayout) findViewById(R.id.refresh_layout);
        postImage = (ImageView) findViewById(R.id.post_image);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        textviewTitle = (TextView) findViewById(R.id.textview_title);
        textviewTime = (TextView) findViewById(R.id.textview_time);
        textviewPostedBy = (TextView) findViewById(R.id.textview_posted_by);
        textviewContentPost = (TextView) findViewById(R.id.textview_content_post);
    }

}
