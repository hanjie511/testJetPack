package com.example.testjetpack.dataSource;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.example.testjetpack.model.Road;
import com.example.testjetpack.model.Translation;
import com.example.testjetpack.service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyDataSource extends PageKeyedDataSource<Integer, Road>{
    int pageNum=1;
    int number=0;
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Road> callback) {
        pageNum=1;
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://cq.yys.com.cn:8010/xcgl/app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Call<Translation> call= retrofit.create(ApiService.class).getData(pageNum);
        call.enqueue(new Callback<Translation>() {
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
            //    System.out.println("response.body().getData():"+response.body().getData());
                List<Road> list=paresData(response.body().getData());
                Log.i("list.size:",""+list.size());
                callback.onResult(list,0,1);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                System.out.println("网络请求失败："+t.getMessage());
            }
        });

    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Road> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Road> callback) {
        pageNum++;
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://cq.yys.com.cn:8010/xcgl/app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Call <Translation>call= retrofit.create(ApiService.class).getData(pageNum);
        call.enqueue(new Callback<Translation>() {
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
            //    System.out.println(response.body().getData());
                List<Road> list=paresData(response.body().getData());
                Log.i("list.size:",""+list.size());
                callback.onResult(list,pageNum);
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }

    private List<Road> paresData(List<Map<String,String>> response) {
        List<Road> list=new ArrayList<>();
        try{
            list.clear();
            Road road=null;
            for(Map m:response){
                number++;
                road=new Road();
                road.setRoadName(number+"、"+m.get("road_name")+"("+m.get("road_start_name")+"-"+m.get("road_end_name")+")");
                road.setRoadCode(""+m.get("road_code"));
                list.add(road);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  list;
    }
}
