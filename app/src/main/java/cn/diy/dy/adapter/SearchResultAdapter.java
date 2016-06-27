package cn.diy.dy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import cn.diy.dy.R;
import cn.diy.dy.entity.SearchResultEntity;

/**
 * Created by orange on 2016/6/27.
 */
public class SearchResultAdapter extends BaseAdapter{

    private List<SearchResultEntity.ResultBean> resultBeanList;
    private Context context;
    private int mode;

    public SearchResultAdapter(Context context,int mode){
        this.context = context;
        this.mode = mode;
    }

    public void bindData(List<SearchResultEntity.ResultBean> resultBeenList){
        this.resultBeanList = resultBeenList;
    }


    @Override
    public int getCount() {
        return resultBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return resultBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        switch(mode){
            case 0:
                TvViewHolder viewHolder;
                if(convertView == null){
                    viewHolder = new TvViewHolder();
                    convertView = (View) LayoutInflater.from(context).inflate(R.layout.every_search_tv_layout,parent,false);
                    viewHolder.cover = (ImageView) convertView.findViewById(R.id.cover);
                    viewHolder.title = (TextView) convertView.findViewById(R.id.title);
                    viewHolder.actorsName = (TextView) convertView.findViewById(R.id.actors_name);
                    viewHolder.style = (TextView) convertView.findViewById(R.id.area_1_year_style_1);
                    viewHolder.total = (TextView) convertView.findViewById(R.id.total);
                    viewHolder.more= (TextView) convertView.findViewById(R.id.more);
                    convertView.setTag(viewHolder);
                }else{
                    viewHolder = (TvViewHolder) convertView.getTag();
                }

                Picasso.with(context).load(resultBeanList.get(position).getCover_url()).resize(255,342).into(viewHolder.cover);

                viewHolder.title.setText(resultBeanList.get(position).getTitle());

                StringBuffer string = new StringBuffer();
                for(String value:resultBeanList.get(position).getActors_name()){
                    string.append(value);
                    string.append("/");
                }
                string.deleteCharAt(string.length()-1);
                viewHolder.actorsName.setText(string.toString());

                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(resultBeanList.get(position).getArea_l());
                stringBuffer.append("/");
                stringBuffer.append(resultBeanList.get(position).getYear());
                stringBuffer.append("/");
                stringBuffer.append(resultBeanList.get(position).getStyle_l());
                viewHolder.style.setText(stringBuffer.toString());

                viewHolder.total.setText(resultBeanList.get(position).getTotal()+"集");

                //TODO: waiting
                viewHolder.more.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                break;
            case 1:

                MovieViewHolder mViewHolder;
                if(convertView == null){
                    mViewHolder = new MovieViewHolder();
                    convertView = (View) LayoutInflater.from(context).inflate(R.layout.every_search_movie_layout,parent,false);
                    mViewHolder.cover = (ImageView) convertView.findViewById(R.id.cover);
                    mViewHolder.title = (TextView) convertView.findViewById(R.id.title);
                    mViewHolder.actorsName = (TextView) convertView.findViewById(R.id.actors_name);
                    mViewHolder.style = (TextView) convertView.findViewById(R.id.area_1_year_style_1);
                    mViewHolder.more= (TextView) convertView.findViewById(R.id.more);
                    convertView.setTag(mViewHolder);
                }else{
                    mViewHolder = (MovieViewHolder) convertView.getTag();
                }

                Picasso.with(context).load(resultBeanList.get(position).getCover_url()).resize(255,342).into(mViewHolder.cover);

                mViewHolder.title.setText(resultBeanList.get(position).getTitle());

                StringBuffer string1 = new StringBuffer();
                for(String value:resultBeanList.get(position).getActors_name()){
                    string1.append(value);
                    string1.append("/");
                }
                string1.deleteCharAt(string1.length()-1);
                mViewHolder.actorsName.setText(string1.toString());

                StringBuffer stringBuffer1 = new StringBuffer();
                stringBuffer1.append(resultBeanList.get(position).getArea_l());
                stringBuffer1.append("/");
                stringBuffer1.append(resultBeanList.get(position).getYear());
                stringBuffer1.append("/");
                stringBuffer1.append(resultBeanList.get(position).getStyle_l());
                mViewHolder.style.setText(stringBuffer1.toString());

                //TODO: waiting
                mViewHolder.more.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                break;
            case 2:
                break;
        }

        return convertView;
    }

    static class TvViewHolder{
        ImageView cover;
        TextView title;
        TextView actorsName;
        TextView style;
        TextView total;
        TextView more;
    }

    static class MovieViewHolder{
        ImageView cover;
        TextView title;
        TextView actorsName;
        TextView style;
        TextView more;
    }



}
