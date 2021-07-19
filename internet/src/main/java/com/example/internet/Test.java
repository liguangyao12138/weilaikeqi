package com.example.internet;

/**
 * @ProjectName : My Application
 * @Author : liguangyao
 * @Time : 2021/7/20
 * @Description : 文件描述
 */
public class Test {

    private int status;
    private String msg;
    private Book data;

    public Test() {
    }

    @Override
    public String toString() {
        return "Test{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public Test(int status, String msg, Book data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Book getData() {
        return data;
    }

    public void setData(Book data) {
        this.data = data;
    }
}
