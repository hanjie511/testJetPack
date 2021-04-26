package com.example.testjetpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.testjetpack.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private MainActivityViewModel mainActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityViewModel=new ViewModelProvider(this).get(MainActivityViewModel.class);
        activityMainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=activityMainBinding.getRoot();
        setContentView(view);
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
    }
}