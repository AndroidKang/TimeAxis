package com.admin.recyclerview.bean;

/**
 * 路口车辆信息
 */

public class TimeAxis {
    private String time; // 时间
    private String data; // 内容
    private String position;// 位置，用于判断头尾

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
