package com.example.fourmajorcomponents.dialogBox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.example.fourmajorcomponents.R;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        findViewById(R.id.btn_dialog_normal).setOnClickListener(this);
        findViewById(R.id.btn_dialog_customize).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dialog_normal:

//                AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                builder.setTitle("提示")
//                        .setMessage("你确定退出程序吗？")
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                finish();
//                            }
//                        })
//                        .setNegativeButton("取消",null);
//                builder.show();
                showNormalDialog();

                break;

            case R.id.btn_dialog_customize:
                MyDialog myDialog = new MyDialog(this,R.style.mydialog);
                myDialog.show();
                break;
        }
    }

    public void showNormalDialog(){

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("提示");
        alertDialog.setMessage("你确定退出程序吗？");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消", (DialogInterface.OnClickListener) null);
        alertDialog.show();
    }
}