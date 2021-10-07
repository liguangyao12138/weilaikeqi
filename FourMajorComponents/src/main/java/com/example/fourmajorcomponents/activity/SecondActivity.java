package com.example.fourmajorcomponents.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fourmajorcomponents.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        findViewById(R.id.tv_activity_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_two = new Intent();
                intent_two.putExtra("myMsg", "这是来自第二个界面的信息");
                setResult(RESULT_OK,intent_two);
                finish();
            }
        });
    }
}