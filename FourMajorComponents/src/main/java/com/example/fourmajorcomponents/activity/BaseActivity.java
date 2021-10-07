package com.example.fourmajorcomponents.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.fourmajorcomponents.R;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    private static String TAG = "lgy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        findViewById(R.id.btn_activity_one).setOnClickListener(this);
        findViewById(R.id.btn_activity_two).setOnClickListener(this);
        findViewById(R.id.btn_activity_three).setOnClickListener(this);
        findViewById(R.id.btn_activity_four).setOnClickListener(this);
        findViewById(R.id.btn_activity_five).setOnClickListener(this);
        findViewById(R.id.btn_activity_six).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart()");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy()");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart()");
        super.onRestart();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_activity_one:

                Intent intent_one = new Intent(this,SecondActivity.class);
                startActivity(intent_one);

                break;

            case R.id.btn_activity_two:
                //普通对话框不会影响生命周期
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("提示")
                        .setMessage("这是一条提示:请认真观察生命周期的变化")
                        .setPositiveButton("确定",null)
                        .show();

                break;

            case R.id.btn_activity_three:

                Intent intent_three = new Intent(this,DialogActivity.class);
                startActivity(intent_three);

                break;

            case R.id.btn_activity_four:

                Intent intent_four = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.imooc.com"));
                startActivity(intent_four);

                break;

            case R.id.btn_activity_five:

                Intent intent_five = new Intent("secondActivity");
                startActivity(intent_five);

                break;

            case R.id.btn_activity_six:

                Intent intent_six = new Intent(this,SecondActivity.class);
                startActivityForResult(intent_six,1000);

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
        if (resultCode == RESULT_OK){
            Log.d(TAG, "requestCode=" + requestCode + ",resultCode=" + resultCode);
            Log.e(TAG,"返回的数据是："+data.getStringExtra("myMsg"));
        }
    }
}