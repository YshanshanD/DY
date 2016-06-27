package cn.diy.dy.utils;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import cn.diy.dy.constant.CommonURL;
import cn.diy.dy.entity.MovieDetailEntity;
import cn.diy.dy.entity.MovieEntity;
import cn.diy.dy.entity.SearchResultEntity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by orange on 2016/6/22.
 */
public class JsonUtils {

    private Context context;
    private OkHttpClient client;

    public JsonUtils(Context context) {
        this.context = context;
        client = new OkHttpClient();
    }

    public Observable<MovieEntity> getMovieJson(final String path) {
        return Observable.create(new Observable.OnSubscribe<MovieEntity>() {
            @Override
            public void call(final Subscriber<? super MovieEntity> subscriber) {
                Log.i(CommonURL.MOVIE_LOG, "ok");
                if (!subscriber.isUnsubscribed()) {
                    Request request = new Request.Builder().url(path).build();
                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            if(response.isSuccessful()){
                                String jsonValue = response.body().string();
                                Log.i(CommonURL.MOVIE_LOG, "json_value == " + jsonValue);
                                MovieEntity entity  = new Gson().fromJson(jsonValue, MovieEntity.class);
                                subscriber.onNext(entity);
                            }
                            subscriber.onCompleted();
                        }
                    });
                }
            }
        });
    }

    public Observable<MovieDetailEntity> getMovieDetailJson(final String path) {
        return Observable.create(new Observable.OnSubscribe<MovieDetailEntity>() {
            @Override
            public void call(final Subscriber<? super MovieDetailEntity> subscriber) {

                if (!subscriber.isUnsubscribed()) {
                    Request request = new Request.Builder().url(path).build();
                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            if(response.isSuccessful()){
                                String jsonValue = response.body().string();
                                System.out.println(jsonValue);
                                MovieDetailEntity entity  = new Gson().fromJson(jsonValue, MovieDetailEntity.class);
                                subscriber.onNext(entity);
                            }
                            subscriber.onCompleted();
                        }
                    });
                }
            }
        });
    }

    public Observable<SearchResultEntity> getSearchResultJson(final String path) {
        return Observable.create(new Observable.OnSubscribe<SearchResultEntity>() {
            @Override
            public void call(final Subscriber<? super SearchResultEntity> subscriber) {

                if (!subscriber.isUnsubscribed()) {
                    Request request = new Request.Builder().url(path).build();
                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            if(response.isSuccessful()){
                                String jsonValue = response.body().string();
                                Log.i(CommonURL.SEARCH_LOG, "json_value == " + jsonValue);
                                SearchResultEntity entity  = new Gson().fromJson(jsonValue, SearchResultEntity.class);
                                subscriber.onNext(entity);
                            }
                            subscriber.onCompleted();
                        }
                    });
                }
            }
        });
    }

}
