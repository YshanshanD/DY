package cn.diy.dy.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.diy.dy.R;
import cn.diy.dy.adapter.SearchViewPagerAdapter;
import cn.diy.dy.constant.CommonURL;
import cn.diy.dy.entity.SearchResultEntity;
import cn.diy.dy.fragment.ResultItemFragment;
import cn.diy.dy.utils.JsonUtils;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SearchResultActivity extends AppCompatActivity implements ResultItemFragment.OnFragmentInteractionListener{

    private JsonUtils jsonUtils;

    private PagerTabStrip title;

    private ViewPager viewPager;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        String url = getIntent().getStringExtra("Result_Url");
        Log.i(CommonURL.SEARCH_LOG,"get url == " + url);

        title=(PagerTabStrip)findViewById(R.id.title);
        viewPager = (ViewPager)findViewById(R.id.view_pager);

        final SearchViewPagerAdapter searchViewPagerAdapter=new SearchViewPagerAdapter(getSupportFragmentManager());



        jsonUtils=new JsonUtils(this);
        jsonUtils.getSearchResultJson(url).observeOn(Schedulers.io())
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
                        if (searchResultEntity!=null){

                            Log.i(CommonURL.SEARCH_LOG,"得到解析的字符串");
                            Map<String,Integer> titleMap=new HashMap<>();

                            titleMap.put("全部",searchResultEntity.getAll_count());
                            titleMap.put("电影",searchResultEntity.getMovie_count());
                            titleMap.put("电视剧",searchResultEntity.getEpisode_count());
                            titleMap.put("卡通",searchResultEntity.getCartoon_count());
                            titleMap.put("综艺",searchResultEntity.getVariety_count());
                            titleMap.put("体育",searchResultEntity.getSports_count());
                            titleMap.put("音乐",searchResultEntity.getMusic_count());
                            titleMap.put("片单",searchResultEntity.getClass_count());
                            titleMap.put("其它",searchResultEntity.getOther_count());
                            titleMap.put("新闻",searchResultEntity.getNews_count());
                            titleMap.put("娱乐",searchResultEntity.getEnt_count());



                            List<String> titleList=new ArrayList<String>();
                            List<Fragment> fragmentList=new ArrayList<Fragment>();
                            for (Map.Entry<String, Integer> value:titleMap.entrySet()) {
                                if (value.getValue()!=0){
                                    titleList.add(value.getKey()+value.getValue());
                                    fragmentList.add(ResultItemFragment.newInstance(" ", " "));
                                }
                            }
                            searchViewPagerAdapter.setTitleList(titleList);
                            searchViewPagerAdapter.setFragmentList(fragmentList);

                            viewPager.setAdapter(searchViewPagerAdapter);

                        }
                    }
                });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        String value;
    }
}
