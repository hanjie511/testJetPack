package com.example.testjetpack;

import android.app.Application;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.ItemKeyedDataSource;
import androidx.paging.PageKeyedDataSource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MyDataSource extends PageKeyedDataSource<Integer,Road>{
    int pageNum=1;
    List<Road> list=new ArrayList<>();
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Road> callback) {
        pageNum=1;
        getData(pageNum);

    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Road> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Road> callback) {

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

    private void paresData(String response) {
        try{
            list.clear();
            Road road=null;
            JSONObject ob=new JSONObject(response);
            JSONArray array=new JSONArray(ob.get("data"));
            for(int index=0;index<array.length();index++){

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
