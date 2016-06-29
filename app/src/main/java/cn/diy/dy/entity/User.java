package cn.diy.dy.entity;

import java.util.List;

/**
 * Created by orange on 2016/6/29.
 */
public class User {
    private String name;
    private String passWord;
    private List<String> titleList;

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public List<String> getTitleList() {
        return titleList;
    }

    public void setTitleList(List<String> titleList) {
        this.titleList = titleList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
