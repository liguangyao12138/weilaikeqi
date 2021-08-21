package com.example.fourmajorcomponents.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.fourmajorcomponents.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        contextMenu();
    }

    //创建OptionsMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option,menu);
        return true;
    }

    //OptionMenu菜单项的选中方法
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_menu_save:
                Toast.makeText(this, "保存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_menu_setting:
                Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_menu_more:
                Toast.makeText(this, "更多", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_contextMenu_delete:
                Toast.makeText(this, "删除", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_contextMenu_opera1:
                Toast.makeText(this, "操作1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_contextMenu_opera2:
                Toast.makeText(this, "操作2", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void contextMenu(){

        registerForContextMenu(findViewById(R.id.btn_menu_context));

    }
}