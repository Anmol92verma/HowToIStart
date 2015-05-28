package com.howtoistart.howtoistart;

import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;
import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import application.MyApplication;
import models.PostsMainModel;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by anmol on 27/5/15.
 */

public class PostsActivity extends ActionBarActivity implements ListView.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener, OnMoreListener {
    private SuperRecyclerView mRecyclerView;
    private android.support.v7.widget.RecyclerView.Adapter mAdapter;
    private android.support.v7.widget.RecyclerView.LayoutManager mLayoutManager;
    private android.support.v7.widget.Toolbar toolbar;
    private android.support.v4.widget.DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ListView leftDrawerList;
    private ArrayAdapter<String> navigationDrawerAdapter;
    private Button fab;
    protected String[] leftSliderData = {"Facebook", "Twitter", "Google+", "Home", "About us"};

    MyApplication application;
    PostsMainModel post_data;
    private int page = 1;
    private int limit = 10;
    private ArrayList<PostsMainModel.Post> my_posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_posts_activity);
        application = (MyApplication) this.getApplication();
        setRef();
        my_posts = new ArrayList<PostsMainModel.Post>();
        //Set the custom toolbar
        if (toolbar != null) {
            toolbar.setTitle(R.string.app_name);
            setSupportActionBar(toolbar);
        }

        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.app_name,
                R.string.app_name
        )

        {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };

        drawerLayout.setDrawerListener(drawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.getRecyclerView().setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.getRecyclerView().setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setRefreshListener(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRecyclerView.getSwipeToRefresh().setRefreshing(true);
                onRefresh();
            }
        }, 500);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    private void setRef() {
        // create reference to the xml views
        mRecyclerView = (SuperRecyclerView) findViewById(R.id.my_recycler_view);
        fab = (Button) findViewById(R.id.addButton);
        drawerLayout = (android.support.v4.widget.DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.setStatusBarBackground(R.color.color_starti);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        leftDrawerList = (ListView) findViewById(R.id.list_drawer);

        View list_header = getLayoutInflater().inflate(R.layout.drawerlist_header, null);
        leftDrawerList.addHeaderView(list_header);
        navigationDrawerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, leftSliderData);
        leftDrawerList.setAdapter(navigationDrawerAdapter);
        leftDrawerList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onRefresh() {
        page = 1;
        limit = 10;
        Map<String, String> params = new HashMap<String, String>();
        params.put("wpapi", "get_posts");
        params.put("dev", "0");
        params.put("count", "" + limit);
        params.put("page", "" + page);

        application.getService().getPosts(params, new Callback<PostsMainModel>() {
            @Override
            public void success(PostsMainModel postsMainModel, Response response) {
                mRecyclerView.getSwipeToRefresh().setRefreshing(false);
                post_data = new PostsMainModel();
                post_data = postsMainModel;
                Log.d("sfdsf", new Gson().toJson(post_data));
                if (post_data.getCurrPage() < post_data.getPages()) {
                    page = page + 1;
                    mRecyclerView.setupMoreListener(PostsActivity.this, (post_data.getCountTotal() - post_data.getCount()));
                } else {

                }
                my_posts.clear();
                my_posts.addAll(post_data.getPosts());
                // specify an adapter (see also next example)
                mAdapter = new MyAdapter(PostsActivity.this, my_posts);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("failure", error.getMessage());
            }
        });
    }

    @Override
    public void onMoreAsked(int i, int i1, int i2) {

        Map<String, String> params = new HashMap<String, String>();
        params.put("wpapi", "get_posts");
        params.put("dev", "0");
        params.put("count", "" + limit);
        params.put("page", "" + page);

        application.getService().getPosts(params, new Callback<PostsMainModel>() {
            @Override
            public void success(PostsMainModel postsMainModel, Response response) {
                mRecyclerView.getSwipeToRefresh().setRefreshing(false);
                post_data = new PostsMainModel();
                post_data = postsMainModel;
                Log.d("sfdsf", new Gson().toJson(post_data));
                if (post_data.getCurrPage() < post_data.getPages()) {
                    page = page + 1;
                    mRecyclerView.setupMoreListener(PostsActivity.this, (post_data.getCountTotal() - post_data.getCount()));
                } else {
                    mRecyclerView.removeMoreListener();
                    mRecyclerView.hideMoreProgress();
                }
                my_posts.addAll(post_data.getPosts());

                // specify an adapter (see also next example)
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("failurwe", error.getMessage());
            }
        });

    }
}