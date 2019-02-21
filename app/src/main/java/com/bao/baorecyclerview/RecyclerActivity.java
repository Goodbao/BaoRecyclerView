package com.bao.baorecyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.bao.baorecyclerview.adapter.DetailAdapter;
import com.bao.baorecyclerview.data.DataDetail;
import com.bao.baorecyclerview.data.DataOther;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 用一个RecyclerView实现功能
 */
public class RecyclerActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private DetailAdapter detailAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 6, GridLayoutManager.VERTICAL, false));
        //滑动监听
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                //判断是否到底部,offset是滑动距离，Extent是控件高度，range是总的内容高度
                if (recyclerView.getChildCount() > 0
                        && recyclerView.computeVerticalScrollOffset() + recyclerView.computeVerticalScrollExtent()
                        >= recyclerView.computeVerticalScrollRange()) {
                    detailAdapter.addData(DataOther.getOtherList());
                }
            }
        });
        detailAdapter = new DetailAdapter(this);
        recyclerView.setAdapter(detailAdapter);

        detailAdapter.addData(DataDetail.getData());
    }
}
