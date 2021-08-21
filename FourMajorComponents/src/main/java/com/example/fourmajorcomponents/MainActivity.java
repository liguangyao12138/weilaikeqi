package com.example.fourmajorcomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fourmajorcomponents.activity.BaseActivity;
import com.example.fourmajorcomponents.menu.MenuActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_main_activity).setOnClickListener(this);
        findViewById(R.id.btn_main_menu).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn_main_activity) {
            Intent intent_baseActivity = new Intent(this, BaseActivity.class);
            startActivity(intent_baseActivity);

        } else if (v.getId() == R.id.btn_main_menu) {
            Intent intent_menu = new Intent(this, MenuActivity.class);
            startActivity(intent_menu);
        }
    }
}