package cn.diy.dy.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import cn.diy.dy.R;
import cn.diy.dy.entity.MovieEntity;
import cn.diy.dy.fragment.MovieFragment.OnListFragmentInteractionListener;
import cn.diy.dy.fragment.dummy.DummyContent.DummyItem;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class MymovieRecyclerViewAdapter extends RecyclerView.Adapter<MymovieRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private List<MovieEntity.ResultBean> resultBeanList;
    private final OnListFragmentInteractionListener mListener;
    private final Context context;

    public MymovieRecyclerViewAdapter(Context context,OnListFragmentInteractionListener mListener) {
        this.context = context;
        this.mListener = mListener;
        resultBeanList = new ArrayList<>();
        mValues = null;
    }

    public MymovieRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
        context = null;
    }

    public void bindData(List<MovieEntity.ResultBean> resultBeanList){
        this.resultBeanList = resultBeanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.resultBean = resultBeanList.get(position);
        holder.mTitle.setText(holder.resultBean.getTitle());
        StringBuffer stringBuffer = new StringBuffer();
        for(String value : holder.resultBean.getActors_name()){
            stringBuffer.append(value);
            stringBuffer.append("/");
        }
        holder.mActorsName.setText(stringBuffer.toString());

        String imageURL = holder.resultBean.getCover_url();
        Picasso.with(context).load(imageURL).resize(255,342).into(holder.mCover);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.resultBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultBeanList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mCover;
        public final TextView mTitle;
        public final TextView mActorsName;
        public MovieEntity.ResultBean resultBean;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mCover = (ImageView) view.findViewById(R.id.cover);
            mTitle = (TextView) view.findViewById(R.id.title);
            mActorsName = (TextView)view.findViewById(R.id.actors_name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitle.getText() + "'";
        }
    }
}
