package com.example.internet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edt_main_accountNumber , edt_main_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_main_get).setOnClickListener(this);
        findViewById(R.id.btn_main_post).setOnClickListener(this);
        edt_main_accountNumber = findViewById(R.id.edt_main_accountNumber);
        edt_main_pwd = findViewById(R.id.edt_main_pwd);

        //在Android4.0以后，会发现，只要是写在主线程（就是Activity）中的HTTP请求，运行时都会报错
        //适用于网络请求数据量很小
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn_main_get) {

            try {
                //HttpURLConnection
                //1.实例化一个URL对象
                URL url = new URL("http://www.imooc.com/api/teacher?type=3&cid=1");

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
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if(v.getId() == R.id.btn_main_post){

            String account = edt_main_accountNumber.getText().toString();
            String pwd  = edt_main_pwd.getText().toString();

            try {
                //HttpURLConnection
                //1.实例化一个URL对象
                URL url = new URL("http://www.imooc.com/api/okhttp/postmethod");

                //2.获取HttpURLConnection实例
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                //3.设置和请求相关的属性
                //请求方式
                connection.setRequestMethod("POST");
                //请求超时时长
                connection.setConnectTimeout(6000);

                //设置允许输出
                connection.setDoOutput(true);
                //设置提交数据的类型
                connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

                //获取输出流
                OutputStream out = connection.getOutputStream();
                //写数据
                out.write(("account="+account+"&pwd="+pwd).getBytes());
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
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            startActivity(new Intent(MainActivity.this,JsonActivity.class));
        }
    }
}