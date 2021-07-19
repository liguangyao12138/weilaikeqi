package com.example.internet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonActivity extends AppCompatActivity {

    private TextView tv_resolveJSON_one;
    private TextView tv_resolveJSON_two;
    private static String TAG = "lgy";
    private ListView list_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        tv_resolveJSON_one = findViewById(R.id.tv_resolveJSON_one);
        tv_resolveJSON_two = findViewById(R.id.tv_resolveJSON_two);
        list_view = findViewById(R.id.list_view);

        findViewById(R.id.btn_resolveJSON).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //resolveJSONObject();
                parseByGSON();
            }
        });
    }

    public void resolveJSONObject(){
        new Thread(){
            @Override
            public void run() {
                super.run();
                String str = get();

                try {

                    JSONObject jsonObject = new JSONObject(str);
                    String msg = jsonObject.getString("msg");

//                    JSONObject data = jsonObject.getJSONObject("data");
//                    String title = data.getString("title");

                    Log.d("lgy", "msg = "+msg);

                    //为listview准备数据源
                    List<Map<String,String>> list = new ArrayList<>();

                    /*
                     **解析JSON数组
                     */
                    JSONArray array = jsonObject.getJSONArray("data");
                    //遍历数组
                    for (int i = 0; i < array.length(); i++) {
                        //取出对应索引上的JSON数据
                        JSONObject arrayJSONObject = array.getJSONObject(i);
                        String name = arrayJSONObject.getString("name");
                        String id = arrayJSONObject.getString("id");
                        Log.d(TAG, "name = "+name+"id = "+id);

                        Map<String,String> map = new HashMap<>();
                        map.put("name",name);
                        map.put("id",id);

                        list.add(map);
                    }

                    //创建SimpleAdapter(数据源 List<Map<String,Object>> , 布局资源  R.layout.item , from,to)
                    String[] from = {"name","id"};
                    int[] to = {R.id.item_name,R.id.item_id};

                    SimpleAdapter adapter = new SimpleAdapter(JsonActivity.this,list,R.layout.item,from,to);
                    //list_view.setAdapter(adapter);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
//                            tv_resolveJSON_one.setText(msg);
//                            tv_resolveJSON_two.setText(title);
                            list_view.setAdapter(adapter);
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public void parseByGSON(){

        //1.添加依赖

        //2.实例化GSON对象
        Gson gson = new Gson();

        //3.toJson
        Book book = new Book("Android 开发","liguangyao","Android从入门到放弃");
        String toJson = gson.toJson(book);
        Log.d(TAG, "toJson = "+toJson);


        //4.fromJson
        Book book1 = gson.fromJson(toJson,Book.class);
        Log.d(TAG, "book1"+book1);

        new Thread(){
            @Override
            public void run() {
                super.run();
                String msg = get();

                Test test = gson.fromJson(msg, Test.class);
                Log.d(TAG, "test = "+test);
                Log.d(TAG, test.getStatus()+"---"+test.getMsg()+"---"+test.getData());
            }
        }.start();
    }

    private String get(){
        try {
            //HttpURLConnection
            //1.实例化一个URL对象
            URL url = new URL("http://www.imooc.com/api/teacher?type=3&cid=1");
            //URL url = new URL("http://www.imooc.com/api/teacher?type=2&cid=1");

            //2.获取HttpURLConnection实例
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //3.设置和请求相关的属性
            //请求方式
            connection.setRequestMethod("GET");
            //请求超时时长
            connection.setConnectTimeout(6000);

            //4.获取相应码 200:成功  404：未请求到指定资源  500：服务器异常
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                //5.判断响应码并获取响应数据(响应的正文)
                InputStream in = connection.getInputStream();
                //在循环中读取输入流
                byte[] b = new byte[1024];
                //in.read(b);
                int len = 0;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                //在循环中读取输入流
                while ((len = in.read(b)) > -1) {
                    //将字节数组里面的内容存/写入缓存流
                    //参数1：待写入数组   2：起点  3：长度
                    baos.write(b, 0, len);
                }

                String msg = new String(baos.toByteArray());
                Log.d("lgy", msg + "=========");

                return msg;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}