package com.tangcco.retrofit;

import com.tangcco.retrofit.bean.GitHubUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/3/18.
 */

public interface GitHubServiceApi {
    @GET("users/octocat/repos")
    Call<List<GitHubUser>>  getUser();
}
