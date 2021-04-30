package com.example.testjetpack.dataSourceFactory;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.example.testjetpack.dataSource.MyDataSource;
import com.example.testjetpack.model.Road;

public class MyDataSourcesFactory extends DataSource.Factory<Integer, Road> {


    @NonNull
    @Override
    public DataSource<Integer, Road> create() {
        MyDataSource myDataSource=new MyDataSource();
        return myDataSource;
    }
}
