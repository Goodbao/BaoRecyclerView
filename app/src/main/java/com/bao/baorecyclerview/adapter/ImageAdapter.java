package com.bao.baorecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bao.baorecyclerview.R;
import com.bao.baorecyclerview.utils.GlideRequestOptions;
import com.bao.baorecyclerview.utils.ToastUtils;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * 图片Adapter
 */

public class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<String> images = new ArrayList<>();

    public ImageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ImageViewHolder) {
            Glide.with(context)
                    .load(images.get(position))
                    .apply(GlideRequestOptions.getInstance().normalRequestOption())
                    .into(((ImageViewHolder) holder).image_item);

            ((ImageViewHolder) holder).image_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showShortToast(String.format("点击第%d张图", position));
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public ImageView image_item;

        public ImageViewHolder(View itemView) {
            super(itemView);
            image_item = (ImageView) itemView.findViewById(R.id.image_item);
        }
    }

    /**
     * 添加数据
     */
    public void addData(List<String> data) {
        this.images.addAll(data);
        notifyDataSetChanged();
    }

    /**
     * 清除数据
     */
    public void clearData() {
        this.images.clear();
        notifyDataSetChanged();
    }
}
