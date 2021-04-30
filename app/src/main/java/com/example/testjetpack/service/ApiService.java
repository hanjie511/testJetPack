package com.example.testjetpack.service;

import com.example.testjetpack.model.Translation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("queryTestDevice.html")
    Call<Translation> getData(@Query("pageNum") int pageNum);

}
