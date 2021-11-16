package com.mohamedabdelaziz.aqwastask.core.presentation.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mohamedabdelaziz.aqwastask.core.data.InternetConnectionLiveData;


public abstract class BaseActivity extends AppCompatActivity {

    public InternetConnectionLiveData connectionLiveData;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connectionLiveData = new InternetConnectionLiveData(this);
        observeNetworkState();
    }

    public void observeNetworkState() {
        connectionLiveData.observe(this, isConnected -> {
            if (isConnected) {
                onConnectionSuccess();
            } else {
                onConnectionFailed();
            }
        });
    }

    protected abstract void onConnectionSuccess();
    protected abstract void onConnectionFailed();


}
