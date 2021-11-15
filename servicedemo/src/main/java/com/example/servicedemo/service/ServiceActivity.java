package com.example.servicedemo.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import com.example.servicedemo.R;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        bindview();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_service_start:
                Intent intent_start = new Intent(this, MyService.class);
                startService(intent_start);
                break;

            case R.id.btn_service_stop:
                Intent intent_stop = new Intent(this, MyService.class);
                stopService(intent_stop);
                break;

            case R.id.btn_service_bind:
                Intent intent_bind = new Intent(this,MyService.class);
                bindService(intent_bind, serviceConnection,BIND_AUTO_CREATE);
                break;

            case R.id.btn_service_unbind:
                unbindService(serviceConnection);
                break;
        }
    }

    //初始化控件
    private  void bindview(){
        findViewById(R.id.btn_service_start).setOnClickListener(this);
        findViewById(R.id.btn_service_stop).setOnClickListener(this);
        findViewById(R.id.btn_service_bind).setOnClickListener(this);
        findViewById(R.id.btn_service_unbind).setOnClickListener(this);

    }
}