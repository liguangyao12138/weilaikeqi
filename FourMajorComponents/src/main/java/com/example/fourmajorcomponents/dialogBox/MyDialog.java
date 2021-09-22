package com.example.fourmajorcomponents.dialogBox;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.fourmajorcomponents.R;

/**
 * @ProjectName : Dialog 对话框
 * @Author : liguangyao
 * @Time : 2021/9/22
 * @Description : 自定义对话框
 */
public class MyDialog extends Dialog {

    public MyDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        //为对话框设置布局
        setContentView(R.layout.dialog_layout);

        findViewById(R.id.btn_dialog_style_yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        findViewById(R.id.btn_dialog_style_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
