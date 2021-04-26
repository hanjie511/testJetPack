package com.example.testjetpack;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.paging.DataSource;

import java.util.List;

public class MyDataSourcesFactory extends DataSource.Factory<String,Road> {


    @NonNull
    @Override
    public DataSource<String, Road> create() {
        MyDataSource myDataSource=new MyDataSource();
        return myDataSource;
    }
}
