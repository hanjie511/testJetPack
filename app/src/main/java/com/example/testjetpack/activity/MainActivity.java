package com.example.testjetpack.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.testjetpack.adapter.MyPagingAdapter;
import com.example.testjetpack.databinding.ActivityMainBinding;
import com.example.testjetpack.model.Road;
import com.example.testjetpack.viewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private MainActivityViewModel mainActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityViewModel=new ViewModelProvider(this).get(MainActivityViewModel.class);
        activityMainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        MyPagingAdapter myPagingAdapter;
        View view=activityMainBinding.getRoot();
        setContentView(view);
        myPagingAdapter=new MyPagingAdapter();
        mainActivityViewModel.initData();
        activityMainBinding.userNameEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mainActivityViewModel.userName.setValue(""+s);
            }
        });
        mainActivityViewModel.getUserName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                activityMainBinding.currentName.setText(s);
            }
        });
        mainActivityViewModel.getRoadLiveData().observe(this, new Observer<PagedList<Road>>() {
            @Override
            public void onChanged(PagedList<Road> roads) {
                myPagingAdapter.submitList(roads);
            }
        });
        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        activityMainBinding.recyclerView.setAdapter(myPagingAdapter);
    }
}