package cn.diy.dy.activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.diy.dy.R;
import cn.diy.dy.adapter.MovieViewPagerAdapter;
import cn.diy.dy.adapter.SearchResultAdapter;
import cn.diy.dy.constant.CommonURL;
import cn.diy.dy.entity.CurrentUser;
import cn.diy.dy.entity.MovieEntity;
import cn.diy.dy.entity.SearchResultEntity;
import cn.diy.dy.fragment.MovieFragment;
import cn.diy.dy.fragment.ResultItemFragment;
import cn.diy.dy.utils.JsonUtils;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DyMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MovieFragment.OnListFragmentInteractionListener, ResultItemFragment.OnFragmentInteractionListener {

    private ViewPager viewPager;//滚动框架

    private PagerTabStrip titleStrip;//滚动框架标题分类

    private List<Fragment> fragmentMovieList;

    private List<Fragment> fragmentTvList;

    private List<Fragment> fragmentAnimaList;

    private Toolbar toolbar;

    private ViewGroup content;

    private LayoutInflater layoutInflater;

    private View movieContentView;//电影视图

    private View searchContentView;//搜索视图

    private View oscarContentView;//奥斯卡视图

    private View collectionContentView;//收藏视图

    private SwipeRefreshLayout refreshLayout;

    private JsonUtils jsonUtils;

    private MovieViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dy_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        content = (ViewGroup) findViewById(R.id.content);
        jsonUtils = new JsonUtils(this);

//        refreshLayout = (SwipeRefreshLayout)findViewById(R.id.refresh_layout);
//        refreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
//        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_light,android.R.color.holo_green_light);
//        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                      refreshLayout.setRefreshing(false);
//                    }
//                },2000);
//            }
//        });

        layoutInflater = LayoutInflater.from(this);

        movieContentView = layoutInflater.inflate(R.layout.movie_content, content, false);
        viewPager = (ViewPager) movieContentView.findViewById(R.id.view_pager);
        titleStrip = (PagerTabStrip) movieContentView.findViewById(R.id.pager_tab_trip);
        titleStrip.setTabIndicatorColor(getResources().getColor(R.color.customColor));
        titleStrip.setBackgroundColor(getResources().getColor(R.color.backcolor));

        adapter = new MovieViewPagerAdapter(getSupportFragmentManager());
        initList();

//        initMovie();
//        initTv();
        initAnime();
//        initOscar();
        DrawerLayout
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        if (drawer != null) {
            drawer.setDrawerListener(toggle);
        }
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_anime);
    }

    private void initList() {
        fragmentMovieList = new ArrayList<>();
        for (int i = 0; i < CommonURL.MOVIE_TITLE.size(); i++) {
            String url = CommonURL.MOVIE.get(CommonURL.MOVIE_TITLE.get(i));
            fragmentMovieList.add(MovieFragment.newInstance(3, 0, url));
//            Log.i("fragmentlist",url);
        }

        fragmentTvList = new ArrayList<>();
        for (int i = 0; i < CommonURL.TV_TITLE.size(); i++) {
            String url = CommonURL.TV.get(CommonURL.TV_TITLE.get(i));
            fragmentTvList.add(MovieFragment.newInstance(3, 1, url));
//            Log.i("fragmentlist",url);
        }

        fragmentAnimaList = new ArrayList<>();
        for (int i = 0; i < CommonURL.ANIMA_TITLE.size(); i++) {
            String url = CommonURL.ANIMA.get(CommonURL.ANIMA_TITLE.get(i));
            fragmentAnimaList.add(MovieFragment.newInstance(3, 2, url));
//            Log.i("fragmentlist",url);
        }
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
        } else if(id ==R.id.nav_quit){
            dealQuit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
//        System.out.println("choose 0f id == " + item.getTitle());
        return true;
    }

    private void dealQuit() {
        CurrentUser.LoginFlag = false;
        Intent intent = new Intent(DyMainActivity.this, GuigeActivity.class);
        startActivity(intent);
    }

    @Override
    public void onListFragmentInteraction(MovieEntity.ResultBean item) {

        if (item != null) {
            String url = CommonURL.PLAY_URL + item.getMid() + ".html";
            Intent intent = new Intent(DyMainActivity.this, ItemDetailActivity.class);
            intent.putExtra("url", url);
            intent.putExtra("mid", item.getMid());
            Bundle bundle = new Bundle();
            bundle.putParcelable("item", item);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    @Override
    public void onComplete(int fragementType) {
        switch (fragementType) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
    }

    public void initMovie() {
        toolbar.setTitle("电影");
        setSupportActionBar(toolbar);

        content.removeAllViews();
        if (fragmentMovieList == null) {
            fragmentMovieList = new ArrayList<>();
            for (int i = 0; i < CommonURL.MOVIE_TITLE.size(); i++) {
                String url = CommonURL.MOVIE.get(CommonURL.MOVIE_TITLE.get(i));
                fragmentMovieList.add(MovieFragment.newInstance(3, 0, url));
                Log.i("fragmentlist", url);
            }
        }

//        adapter.setFragmentList(fragmentMovieList);
        adapter.setFragments(fragmentMovieList);
        adapter.setTitleList(CommonURL.MOVIE_TITLE);
        viewPager.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
        content.addView(movieContentView);
    }

    public void initTv() {
        toolbar.setTitle("电视剧");
        setSupportActionBar(toolbar);

        content.removeAllViews();
        if (fragmentTvList == null) {
            fragmentTvList = new ArrayList<>();
            for (int i = 0; i < CommonURL.TV_TITLE.size(); i++) {
                String url = CommonURL.TV.get(CommonURL.TV_TITLE.get(i));
                fragmentTvList.add(MovieFragment.newInstance(3, 1, url));
                Log.i("fragmentlist", url);
            }
        }

//        adapter.setFragmentList(fragmentTvList);
        adapter.setFragments(fragmentTvList);
        adapter.setTitleList(CommonURL.TV_TITLE);
        viewPager.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
        content.addView(movieContentView);
    }

    public void initAnime() {
        toolbar.setTitle("动漫");
        setSupportActionBar(toolbar);
        content.removeAllViews();
        if (fragmentAnimaList == null) {
            fragmentAnimaList = new ArrayList<>();
            for (int i = 0; i < CommonURL.ANIMA_TITLE.size(); i++) {
                String url = CommonURL.ANIMA.get(CommonURL.ANIMA_TITLE.get(i));
                fragmentAnimaList.add(MovieFragment.newInstance(3, 2, url));
                Log.i("fragmentlist", url);
            }
        }


//        adapter.setFragmentList(fragmentAnimaList);
        adapter.setFragments(fragmentAnimaList);
        adapter.setTitleList(CommonURL.ANIMA_TITLE);
        viewPager.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
        content.addView(movieContentView);
    }

    public void initSearch() {
        toolbar.setTitle("搜索");

        content.removeAllViews();
        if (searchContentView == null) {
            Log.i(CommonURL.SEARCH_LOG, "ok");
            searchContentView = layoutInflater.inflate(R.layout.search_content, null, false);

            final Spinner spinner = (Spinner) searchContentView.findViewById(R.id.spinner);

            List<String> list = new ArrayList<>();
            list.add("电视剧");
            list.add("电影");
            list.add("动漫");
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
            spinner.setAdapter(arrayAdapter);

            final EditText editText = (EditText) searchContentView.findViewById(R.id.editText);
            ImageButton searchButton = (ImageButton) searchContentView.findViewById(R.id.search_button);

            searchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String searchText = editText.getText().toString();
                    String url = CommonURL.SEARCH_URL + searchText;
                    Log.i(CommonURL.SEARCH_LOG, "seach_url == " + url);
                    Intent intent = new Intent(DyMainActivity.this, SearchResultActivity.class);
                    intent.putExtra("Result_Url", url);
                    intent.putExtra("Search_Mode", spinner.getSelectedItemPosition());

                    startActivity(intent);
                }
            });

        }
        content.addView(searchContentView);
    }

    public void initOscar() {
        toolbar.setTitle("奥斯卡");
        content.removeAllViews();
        if (oscarContentView == null) {
            oscarContentView = layoutInflater.inflate(R.layout.oscar_content, null, false);
            final Spinner spinner = (Spinner) oscarContentView.findViewById(R.id.spinner);
            final List<String> list = new ArrayList<>();
            for (int i = 2015; i >= 2011; i--) {
                list.add(String.valueOf(i));
            }
            ArrayAdapter adapter = new ArrayAdapter(this, R.layout.custom_spinner_item, R.id.spinner_item, list);
            spinner.setAdapter(adapter);


            final ListView listView = (ListView) oscarContentView.findViewById(R.id.oscar_list);

            final SearchResultAdapter adapter1 = new SearchResultAdapter(this, 1, this);
            final List<SearchResultEntity.ResultBean> resultBeanList = new ArrayList<>();

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    resultBeanList.clear();
                    String value = list.get(position);
                    final List<String> movieList = CommonURL.OSCAR_SET.get(value);

                    for (int i = 0; i < movieList.size(); i++) {
                        final String movieName = movieList.get(i);
                        String url = CommonURL.SEARCH_URL + movieName;
                        jsonUtils.getSearchResultJson(url).subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Subscriber<SearchResultEntity>() {
                                    @Override
                                    public void onCompleted() {

                                    }

                                    @Override
                                    public void onError(Throwable e) {

                                    }

                                    @Override
                                    public void onNext(SearchResultEntity searchResultEntity) {
                                        for (SearchResultEntity.ResultBean bean : searchResultEntity.getResult()) {
                                            if (bean.getType_l().equals("电影") && bean.getTitle().equals(movieName) && !bean.getCover_url().trim().equals("")) {
                                                resultBeanList.add(bean);
                                                Log.i(CommonURL.OSCAR_LOG, "电影名字 == " + bean.getTitle());
                                                break;
                                            }
                                        }
                                        adapter1.bindData(resultBeanList);
                                        listView.setAdapter(adapter1);
                                        adapter1.notifyDataSetChanged();
                                        Log.i(CommonURL.OSCAR_LOG, "电影总数 == " + resultBeanList.size());

                                    }
                                });
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }
        content.addView(oscarContentView);
    }

    public void initCollection() {
        toolbar.setTitle("收藏");
        content.removeAllViews();//切换界面
        if (CurrentUser.LoginFlag == false) {
            Intent intent = new Intent(DyMainActivity.this, GuigeActivity.class);
            startActivity(intent);
        } else {
            if (collectionContentView == null) {
                collectionContentView = layoutInflater.inflate(R.layout.collection_content, null, false);//生成视图
            }
                final TextView userView = (TextView) collectionContentView.findViewById(R.id.user_name);
                final ListView listView = (ListView) collectionContentView.findViewById(R.id.list_view);//列表生成
                userView.setText(CurrentUser.user.getName());
                Log.e("test5",CurrentUser.user.getName());
                List<String> list = new ArrayList<>();//初始化数组列表list
                for (String value : CurrentUser.user.getTitleList()) {
                    list.add(value);//
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);//建一个系统自带的适配器
                listView.setAdapter(arrayAdapter);//更新数据并显示
                arrayAdapter.notifyDataSetChanged();
            content.addView(collectionContentView);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
