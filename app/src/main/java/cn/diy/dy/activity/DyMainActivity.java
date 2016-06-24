package cn.diy.dy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.diy.dy.R;
import cn.diy.dy.adapter.MovieViewPagerAdapter;
import cn.diy.dy.constant.CommonURL;
import cn.diy.dy.entity.MovieEntity;
import cn.diy.dy.fragment.MovieFragment;

public class DyMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MovieFragment.OnListFragmentInteractionListener {

    private ViewPager viewPager;//滚动框架

    private PagerTabStrip titleStrip;//滚动框架标题分类

    private List<Fragment> fragmentList;

    private Toolbar toolbar;

    private ViewGroup content;

    private LayoutInflater layoutInflater;

    private View everyContentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dy_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        content = (ViewGroup) findViewById(R.id.content);

        layoutInflater = LayoutInflater.from(this);


        initMovie();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        if(drawer != null) {
            drawer.setDrawerListener(toggle);
        }
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_movie);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dy_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_movie) {
            initMovie();
        } else if (id == R.id.nav_tv) {
            initTv();


        } else if (id == R.id.nav_anime) {
            initAnime();
        } else if (id == R.id.nav_search) {
            initSearch();
        } else if (id == R.id.nav_oscar) {
            initOscar();
        } else if (id == R.id.nav_collection) {
            initCollection();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
//        System.out.println("choose 0f id == " + item.getTitle());
        return true;
    }

    @Override
    public void onListFragmentInteraction(MovieEntity.ResultBean item) {

        if (item != null) {
            Toast.makeText(DyMainActivity.this, "------" + item.getTitle(), Toast.LENGTH_SHORT).show();
            String url = CommonURL.PLAY_URL + item.getMid() + ".html";
            Intent intent = new Intent(DyMainActivity.this, ItemDetailActivity.class);
            intent.putExtra("url", url);
            Bundle bundle = new Bundle();
            bundle.putParcelable("item", item);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    public void initMovie() {

        toolbar.setTitle("电影");

        everyContentView = layoutInflater.inflate(R.layout.movie_content, null, false);

        content.removeAllViews();
        content.addView(everyContentView);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        titleStrip = (PagerTabStrip) findViewById(R.id.pager_tab_trip);
        titleStrip.setTabIndicatorColor(getResources().getColor(R.color.customColor));
        titleStrip.setBackgroundColor(getResources().getColor(R.color.backcolor));

        setSupportActionBar(toolbar);
        fragmentList = new ArrayList<>();
        for (int i = 0; i < CommonURL.MOVIE_TITLE.size(); i++) {
            fragmentList.add(MovieFragment.newInstance(3, i, CommonURL.MOVIE.get(CommonURL.MOVIE_TITLE.get(i))));
        }
        MovieViewPagerAdapter adapter = new MovieViewPagerAdapter(getSupportFragmentManager());
        adapter.setFragmentList(fragmentList);
        adapter.setTitleList(CommonURL.MOVIE_TITLE);
        viewPager.setAdapter(adapter);

    }

    public void initTv() {
        toolbar.setTitle("电视剧");
        content.removeAllViews();
    }

    public void initAnime() {
        toolbar.setTitle("动漫");
        content.removeAllViews();
    }

    public void initSearch() {
        toolbar.setTitle("搜素");
        everyContentView = layoutInflater.inflate(R.layout.search_content,null,false);
        content.removeAllViews();
        content.addView(everyContentView);
    }

    public void initOscar() {
        toolbar.setTitle("奥斯卡");
    }

    public void initCollection() {
        toolbar.setTitle("收藏");
    }
}
