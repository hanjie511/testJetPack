package com.example.testjetpack.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.testjetpack.dataSource.MyDataSource;
import com.example.testjetpack.dataSourceFactory.MyDataSourcesFactory;
import com.example.testjetpack.model.Road;

public class MainActivityViewModel extends ViewModel {
    public MutableLiveData<String> userName;
    public MyDataSource myDataSource;
    public LiveData<PagedList<Road>> getRoadLiveData() {
        return roadLiveData;
    }

    private LiveData<PagedList<Road>> roadLiveData;
    public LiveData<String> getUserName() {
        if(userName==null){
            userName=new MutableLiveData<>();
        }
        return userName;
    }
    public void initData(){
        MyDataSourcesFactory myDataSourcesFactory=new MyDataSourcesFactory();
        myDataSource= (MyDataSource) myDataSourcesFactory.create();
        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(10)
                        .setPageSize(20).build();
        roadLiveData =new LivePagedListBuilder(myDataSourcesFactory,pagedListConfig).build();
    }
    public void invalidateDataSource() {
        myDataSource.invalidate();
    }
}
