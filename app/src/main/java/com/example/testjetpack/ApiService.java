package com.example.testjetpack;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("queryTestDevice.html")
    Call<Translation> getData(@Query("pageNum") int pageNum);

}
