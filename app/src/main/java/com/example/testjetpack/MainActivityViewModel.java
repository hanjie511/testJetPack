package com.example.testjetpack;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class MainActivityViewModel extends ViewModel {
    MutableLiveData<String> userName;
    MyDataSource myDataSource;
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
