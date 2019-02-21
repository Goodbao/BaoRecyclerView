package com.bao.baorecyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bao.baorecyclerview.adapter.ImageAdapter;
import com.bao.baorecyclerview.adapter.OtherAdapter;
import com.bao.baorecyclerview.adapter.ProductAdapter;
import com.bao.baorecyclerview.bean.BeanProduct;
import com.bao.baorecyclerview.data.DataImage;
import com.bao.baorecyclerview.data.DataOther;
import com.bao.baorecyclerview.data.DataProduct;
import com.bao.baorecyclerview.utils.GlideRequestOptions;
import com.bao.baorecyclerview.utils.ToastUtils;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 用NestedScrollView实现功能
 */

public class NestedScrollActivity extends AppCompatActivity {
    @BindView(R.id.nestedScrollView)
    NestedScrollView nestedScrollView;
    @BindView(R.id.image_head)
    ImageView imageHead;
    @BindView(R.id.image_designer)
    ImageView imageDesigner;
    @BindView(R.id.tv_designer)
    TextView tvDesigner;
    @BindView(R.id.rl_designer)
    RelativeLayout rlDesigner;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.ll_description)
    LinearLayout llDescription;
    @BindView(R.id.image_video)
    ImageView imageVideo;

    //图片占满宽度
    @BindView(R.id.recyclerView_image)
    RecyclerView recyclerViewImage;
    //一行3个商品
    @BindView(R.id.recyclerView_product)
    RecyclerView recyclerViewProduct;
    //一行2个其他系列
    @BindView(R.id.recyclerView_other)
    RecyclerView recyclerViewOther;

    private GridLayoutManager gridLayoutManagerProduct;

    private ImageAdapter imageAdapter;
    private ProductAdapter productAdapter;
    private OtherAdapter otherAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        ButterKnife.bind(this);

        initView();
        setData();
    }

    private void initView() {
        //滑动监听
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                View view = v.getChildAt(0);
                if (view.getHeight() == scrollY + v.getHeight()) {
                    //加载更多、增加数据
                    otherAdapter.addData(DataOther.getOtherList());
                }
            }
        });
        //LinearLayoutManager，垂直方向
        recyclerViewImage.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //设置滑动惯性
        recyclerViewImage.setNestedScrollingEnabled(false);
        //配置adapter
        imageAdapter = new ImageAdapter(this);
        recyclerViewImage.setAdapter(imageAdapter);


        //GridLayoutManager，每行3个item，垂直方向
        gridLayoutManagerProduct = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        //设置头部占3个，其他占1个
        gridLayoutManagerProduct.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (productAdapter.getItemViewType(position) == ProductAdapter.ITEM_HEAD) {
                    return 3;
                } else {
                    return 1;
                }
            }
        });
        recyclerViewProduct.setLayoutManager(gridLayoutManagerProduct);
        //设置滑动惯性
        recyclerViewProduct.setNestedScrollingEnabled(false);
        productAdapter = new ProductAdapter(this);
        //设置点击事件
        productAdapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, BeanProduct.BeanData data) {
                ToastUtils.showShortToast(data.getName() + "价格：" + data.getPrice());
            }

            @Override
            public void onItemLongClick(View view, int position, BeanProduct.BeanData data) {
                ToastUtils.showShortToast("长按商品:" + data.getName());
            }
        });
        recyclerViewProduct.setAdapter(productAdapter);


        //GridLayoutManager，每行2个item，垂直方向
        recyclerViewOther.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
        //设置滑动惯性
        recyclerViewOther.setNestedScrollingEnabled(false);
        otherAdapter = new OtherAdapter(this);
        recyclerViewOther.setAdapter(otherAdapter);
    }

    /**
     * 设置数据
     */
    private void setData() {
        //头部图片
        Glide.with(this)
                .load("https://images.pexels.com/photos/428124/pexels-photo-428124.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb")
                .apply(GlideRequestOptions.getInstance().normalRequestOption())
                .into(imageHead);

        Glide.with(this)
                .load("https://images.pexels.com/photos/428336/pexels-photo-428336.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb")
                .apply(GlideRequestOptions.getInstance().circleRequestOption())
                .into(imageDesigner);

        Glide.with(this)
                .load("https://images.pexels.com/photos/428301/pexels-photo-428301.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb")
                .apply(GlideRequestOptions.getInstance().normalRequestOption())
                .into(imageVideo);


        imageAdapter.addData(DataImage.getImageList());

        productAdapter.addData(DataProduct.getProductList());

        otherAdapter.addData(DataOther.getOtherList());
    }

    @OnClick({R.id.rl_designer, R.id.image_video})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_designer:
                Toast.makeText(this, "设计师介绍", Toast.LENGTH_SHORT).show();
                break;
            case R.id.image_video:
                Toast.makeText(this, "播放视频", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
