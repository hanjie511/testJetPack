package com.example.testjetpack;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.paging.DataSource;

import java.util.List;

public class MyDataSourcesFactory extends DataSource.Factory<Integer,Road> {


    @NonNull
    @Override
    public DataSource<Integer, Road> create() {
        MyDataSource myDataSource=new MyDataSource();
        return myDataSource;
    }
}
