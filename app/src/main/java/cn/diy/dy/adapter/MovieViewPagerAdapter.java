package cn.diy.dy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import java.util.List;

import cn.diy.dy.fragment.MovieFragment;

/**
 * Created by orange on 2016/6/22.
 */
public class MovieViewPagerAdapter extends FragmentPagerAdapter{


    private List<String> titleList;
    private List<Fragment> fragmentList;
    private FragmentManager fm;

    public MovieViewPagerAdapter(FragmentManager fm) {
        super(fm);
        this.fm = fm;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }



    public void setTitleList(List<String> titleList) {
        this.titleList = titleList;
    }

    public void setFragmentList(List<Fragment> fragmentList) {
        this.fragmentList = fragmentList;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    public void setFragments(List<Fragment> fragments) {
        Log.e("test3","--------" + (fragmentList == null));
//        Log.e("test3","--------" + fm.getFragments().size());
        if(this.fragmentList != null){
            FragmentTransaction ft = fm.beginTransaction();
            Log.e("test3","--------start" + fragmentList.size());
            for(Fragment f:this.fragmentList){
                Log.e("test3","type == " +f.getArguments().getInt(MovieFragment.FRAGEMENT_TYPE));
                ft.remove(f);
            }
            ft.commit();
            ft=null;
            fm.executePendingTransactions();
            Log.e("test3","--------end" + fragmentList.size());
        }
        this.fragmentList = fragments;
        notifyDataSetChanged();
    }
}
