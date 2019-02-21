package com.bao.baorecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
{

    @BindView(R.id.btn_scroll)
    Button btnScroll;
    @BindView(R.id.btn_recycler)
    Button btnRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_scroll, R.id.btn_recycler})
    public void onViewClicked(View view)
    {
        switch (view.getId())
        {
            case R.id.btn_scroll:
                startActivity(new Intent(this,NestedScrollActivity.class));
                break;
            case R.id.btn_recycler:
                startActivity(new Intent(this,RecyclerActivity.class));
                break;
        }
    }
}
