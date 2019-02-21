package com.bao.baorecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bao.baorecyclerview.R;
import com.bao.baorecyclerview.bean.BeanOther;
import com.bao.baorecyclerview.utils.GlideRequestOptions;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * 其他系列Adapter
 */

public class OtherAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<BeanOther> otherList = new ArrayList<>();

    public OtherAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OtherViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_other, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof OtherViewHolder) {
            ((OtherViewHolder) holder).tv_name.setText(otherList.get(position).getName());

            Glide.with(context)
                    .load(otherList.get(position).getImage())
                    .apply(GlideRequestOptions.getInstance().normalRequestOption())
                    .into(((OtherViewHolder) holder).image_other);
        }
    }

    @Override
    public int getItemCount() {
        return otherList.size();
    }

    public class OtherViewHolder extends RecyclerView.ViewHolder {
        public ImageView image_other;
        public TextView tv_name;

        public OtherViewHolder(View itemView) {
            super(itemView);
            image_other = (ImageView) itemView.findViewById(R.id.image_other);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }

    /**
     * 添加数据
     */
    public void addData(List<BeanOther> data) {
        this.otherList.addAll(data);
        notifyDataSetChanged();
    }

    /**
     * 清除数据
     */
    public void clearData() {
        this.otherList.clear();
        notifyDataSetChanged();
    }
}
