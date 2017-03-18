package com.tangcco.retrofit;

import com.tangcco.retrofit.bean.Robot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/3/18.
 */

public interface GitHubApi {
//http://op.juhe.cn/robot/index?info=你好啊&key=c42e8ba0246500486843f471dd36ab28
    @GET("robot/index")
    Call<Robot> getRobot(@Query("info") String info, @Query("key") String key);

    @POST("robot/index")
    Observable<Robot> getRobot2(@Query("info") String info, @Query("key") String key);
}
