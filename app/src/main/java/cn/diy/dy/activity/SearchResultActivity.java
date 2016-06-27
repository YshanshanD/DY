package cn.diy.dy.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.diy.dy.R;
import cn.diy.dy.adapter.SearchResultAdapter;
import cn.diy.dy.constant.CommonURL;
import cn.diy.dy.entity.SearchResultEntity;
import cn.diy.dy.fragment.ResultItemFragment;
import cn.diy.dy.utils.JsonUtils;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SearchResultActivity extends AppCompatActivity implements ResultItemFragment.OnFragmentInteractionListener{

    private JsonUtils jsonUtils;

    private ListView listView;

    private int mode;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mode = getIntent().getIntExtra("Search_Mode",-1);

        setContentView(R.layout.search_layout);

        listView = (ListView)findViewById(R.id.list_view);

        String url = getIntent().getStringExtra("Result_Url");
        Log.i(CommonURL.SEARCH_LOG,"get url == " + url);

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

                            Log.i(CommonURL.SEARCH_LOG,"得到解析的字符串"+mode);
                            String valueMode = null;
                            switch (mode){
                                case 0:
                                    valueMode = "电视剧";

                                    break;

                                case 1:

                                    valueMode = "电视剧";
                                    break;
                                case 2:

                                    valueMode = "动漫";
                                    break;
                            }

                            SearchResultAdapter adapter = new SearchResultAdapter(SearchResultActivity.this,0);
                            List<SearchResultEntity.ResultBean> resultBeanList = new ArrayList<>();
                            for (int i = 0; i < searchResultEntity.getResult().size(); i++) {
                                if(searchResultEntity.getResult().get(i).getType_l().equals(valueMode)){
                                    resultBeanList.add(searchResultEntity.getResult().get(i));
                                }
                            }
                            Log.i(CommonURL.SEARCH_LOG,valueMode+"个数等于 " + resultBeanList.size());
                            adapter.bindData(resultBeanList);
                            listView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();

                        }
                    }
                });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        String value;
    }
}
