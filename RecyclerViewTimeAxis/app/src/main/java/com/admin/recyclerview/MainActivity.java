package com.admin.recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.admin.recyclerview.adapter.TimeAxisQuickAdapter;
import com.admin.recyclerview.bean.TimeAxis;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    Context context;
    private List<TimeAxis> dataList; // 数据源

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        context = this;

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        setData();// 设置数据
        TimeAxisQuickAdapter recyclerAdapter =
                new TimeAxisQuickAdapter(dataList);// 适配器
        recyclerView.setAdapter(recyclerAdapter);// 设置适配器
    }

    /**
     * 设置数据
     */
    private void setData() {
        // 初始化数据源
        if (dataList == null) {
            dataList = new ArrayList<>();
        } else {
            dataList.clear();
        }

        TimeAxis timeAxis;

        timeAxis = new TimeAxis();
        timeAxis.setTime("15:10");
        timeAxis.setData("这是内容");
        timeAxis.setPosition("0");
        dataList.add(timeAxis);

        timeAxis = new TimeAxis();
        timeAxis.setTime("15:20");
        timeAxis.setData("这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容\n" +
                "这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这");
        timeAxis.setPosition("");
        dataList.add(timeAxis);

        timeAxis = new TimeAxis();
        timeAxis.setTime("15:30");
        timeAxis.setData("这是内容这是内容这是内容这是内容这是内容这是内容这是内容");
        timeAxis.setPosition("");
        dataList.add(timeAxis);

//        timeAxis = new TimeAxis();
//        timeAxis.setTime("15:40");
//        timeAxis.setData("这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容\n" +
//                "这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这\n" +
//                "这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容");
//        timeAxis.setPosition("");
//        dataList.add(timeAxis);
//
//        timeAxis = new TimeAxis();
//        timeAxis.setTime("15:50");
//        timeAxis.setData("这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容\n" +
//                "这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这\n" +
//                "这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容");
//        timeAxis.setPosition("");
//        dataList.add(timeAxis);

        timeAxis = new TimeAxis();
        timeAxis.setTime("16:00");
        timeAxis.setData("这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容\n" +
                "这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这\n" +
                "这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容");
        timeAxis.setPosition("1");
        dataList.add(timeAxis);
    }
}
