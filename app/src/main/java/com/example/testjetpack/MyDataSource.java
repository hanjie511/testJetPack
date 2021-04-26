package com.example.testjetpack;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.paging.ItemKeyedDataSource;
import androidx.paging.PageKeyedDataSource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MyDataSource extends PageKeyedDataSource<String,Road>{
    int pageNum=1;
    @Override
    public void loadInitial(@NonNull LoadInitialParams<String> params, @NonNull LoadInitialCallback<String, Road> callback) {
        pageNum=1;
        getData(pageNum);

    }

    @Override
    public void loadBefore(@NonNull LoadParams<String> params, @NonNull LoadCallback<String, Road> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<String> params, @NonNull LoadCallback<String, Road> callback) {

    }
    private void getData(int pageNum){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://cq.yys.com.cn:8010/xcgl/app/")
                .build();
        Call call= (Call) retrofit.create(ApiService.class);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                paresData(response.body().toString());
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }
    private void paresData(String response){

    }

}
