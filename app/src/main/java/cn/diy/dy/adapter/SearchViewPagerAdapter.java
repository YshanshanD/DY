package cn.diy.dy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by orange on 2016/6/27.
 */
public class SearchViewPagerAdapter extends FragmentPagerAdapter {

    private List<String> titleList;
    private List<Fragment> fragmentList;


    public SearchViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return titleList.size();
    }

    public List<String> getTitleList() {
        return titleList;
    }

    /**
     * 返回 viewpager 的标题
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    public void setTitleList(List<String> titleList) {
        this.titleList = titleList;
    }

    public List<Fragment> getFragmentList() {
        return fragmentList;
    }

    public void setFragmentList(List<Fragment> fragmentList) {
        this.fragmentList = fragmentList;
    }
}
