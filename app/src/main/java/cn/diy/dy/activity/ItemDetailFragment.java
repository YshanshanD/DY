package cn.diy.dy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.diy.dy.R;
import cn.diy.dy.constant.CommonURL;
import cn.diy.dy.entity.MovieDetailEntity;
import cn.diy.dy.entity.MovieEntity;
import cn.diy.dy.utils.JsonUtils;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {



    private MovieEntity.ResultBean mItem;

    private CollapsingToolbarLayout appBarLayout;

    private JsonUtils utils;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mItem = getArguments().getParcelable("item");
        utils = new JsonUtils(getContext());

        Activity activity = this.getActivity();
        appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
        if (appBarLayout != null) {
            appBarLayout.setTitle(mItem.getTitle());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        final TextView directorsName = (TextView)rootView.findViewById(R.id.directors_name);
        final TextView actorsName = (TextView)rootView.findViewById(R.id.actors_name);
        final TextView styleName = (TextView)rootView.findViewById(R.id.style_name);
        final TextView updateTime = (TextView)rootView.findViewById(R.id.update_time);
        final TextView clicks = (TextView)rootView.findViewById(R.id.clicks);
        final TextView desc = (TextView)rootView.findViewById(R.id.desc);

        if (mItem != null) {
            String url = CommonURL.MOVIE_DETAIL_URL + mItem.getId();

            Log.i(CommonURL.MOVIE_LOG, "detail_url == " + url);
            utils.getMovieDetailJson(url).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<MovieDetailEntity>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(MovieDetailEntity movieDetailEntity) {
                            if(movieDetailEntity != null){
                                StringBuffer stringBuffer = new StringBuffer();
                                for (String value:movieDetailEntity.getDirectors_name()) {
                                    stringBuffer.append(value);
                                    stringBuffer.append("/");
                                }
                                stringBuffer.delete(stringBuffer.length()-1,stringBuffer.length());

                                directorsName.setText(stringBuffer.toString());
                                stringBuffer.delete(0,stringBuffer.length());
                                for(String value:movieDetailEntity.getActors_name()){
                                    stringBuffer.append(value);
                                    stringBuffer.append("/");
                                }
                                stringBuffer.delete(stringBuffer.length()-1,stringBuffer.length());

                                actorsName.setText(stringBuffer.toString());

                                stringBuffer.delete(0,stringBuffer.length());
                                for(String value:movieDetailEntity.getStyle_name()){
                                    stringBuffer.append(value);
                                    stringBuffer.append("/");
                                }
                                stringBuffer.delete(stringBuffer.length()-1,stringBuffer.length());
                                styleName.setText(stringBuffer.toString());

                                updateTime.setText(movieDetailEntity.getUpdate_time());

                                clicks.setText(movieDetailEntity.getClicks()+"");

                                desc.setText(movieDetailEntity.getDesc());

                            }
                        }
                    });
        }

        return rootView;
    }
}
