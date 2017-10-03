package com.admin.recyclerview.adapter;

import android.view.View;

import com.admin.recyclerview.R;
import com.admin.recyclerview.bean.TimeAxis;
import com.admin.recyclerview.util.Info;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class TimeAxisQuickAdapter extends BaseItemDraggableAdapter<TimeAxis> {

    public TimeAxisQuickAdapter(List<TimeAxis> data) {
        super(R.layout.time_axis_mb, data);
        List<TimeAxis> list = data;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, TimeAxis timeAxis) {
        baseViewHolder
                .setText(R.id.construction_detail_tv_time, timeAxis.getTime())// 时间
                .setText(R.id.construction_detail_tv_data, timeAxis.getData())// 内容
                .setVisible(R.id.construction_detail_other_line, (Info.isEmptyOrNullString(timeAxis.getPosition())
                        || !timeAxis.getPosition().equals("1")));// 判断是不是尾，如果是，隐藏;

        // 判断是不是开头，如果是，隐藏开始的线
        View view_TopLine = baseViewHolder.getView(R.id.construction_detail_top_line);
        if ((!Info.isEmptyOrNullString(timeAxis.getPosition())
                && timeAxis.getPosition().equals("0"))) {
            view_TopLine.setVisibility(View.INVISIBLE);
        }
    }
}