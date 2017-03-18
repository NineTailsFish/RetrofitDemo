package com.tangcco.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.tangcco.retrofit.bean.GitHubUser;
import com.tangcco.retrofit.bean.Robot;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //https://api.github.com/users/octocat/repos
    }

    public void aaaaa(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubServiceApi user = retrofit.create(GitHubServiceApi.class);
        user.getUser().enqueue(new Callback<List<GitHubUser>>() {
            @Override
            public void onResponse(Call<List<GitHubUser>> call, Response<List<GitHubUser>> response) {

                Log.e(TAG, "onResponse: " + response.body().size());
                for (GitHubUser u : response.body()) {
                    Log.e(TAG, "onResponse: " + u.toString());

                }
            }

            @Override
            public void onFailure(Call<List<GitHubUser>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t);
            }
        });
        ;
//        Call<List<GitHubUser>> list = user.getUser();
//        list
    }


    public void getRobot(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://op.juhe.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofit.create(GitHubApi.class)
                .getRobot("你好啊", "c42e8ba0246500486843f471dd36ab28")
                .enqueue(new Callback<Robot>() {
            @Override
            public void onResponse(Call<Robot> call, Response<Robot> response) {
                Log.e(TAG, "onResponse: " + Thread.currentThread().getName());
                Log.e(TAG, "onResponse: " + response.body().toString());
            }

            @Override
            public void onFailure(Call<Robot> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t);
            }
        });
    }

    public void getRobot2(View view) {
        new Retrofit.Builder()
                .baseUrl("http://op.juhe.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(GitHubApi.class)
                .getRobot2("你好啊", "c42e8ba0246500486843f471dd36ab28")
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(new Action1<Robot>() {
                    @Override
                    public void call(Robot robot) {
                        Log.e(TAG, "call: "+robot.toString());
                    }
                });
    }
}
