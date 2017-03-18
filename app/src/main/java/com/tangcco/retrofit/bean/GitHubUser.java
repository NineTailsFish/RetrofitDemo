package com.tangcco.retrofit.bean;

/**
 * Created by Administrator on 2017/3/18.
 */

public class GitHubUser {
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "GitHubUser{" +
                "user='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
