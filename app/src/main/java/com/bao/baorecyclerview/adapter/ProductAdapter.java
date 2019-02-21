package com.bao.baorecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bao.baorecyclerview.R;
import com.bao.baorecyclerview.bean.BeanProduct;
import com.bao.baorecyclerview.utils.GlideRequestOptions;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品adapter
 */

public class ProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int ITEM_HEAD = 0;
    public static final int ITEM_PRODUCT = 1;

    private Context context;
    private List<Object> datas = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public ProductAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_PRODUCT) {
            return new ProductViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_product, parent, false));
        } else {
            return new HeadViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_head_tv, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ProductViewHolder) {
            final BeanProduct.BeanData data = (BeanProduct.BeanData) datas.get(position);
            ((ProductViewHolder) holder).tv_name.setText(data.getName());
            ((ProductViewHolder) holder).tv_price.setText(data.getPrice());

            Glide.with(context)
                    .load(data.getImage())
                    .apply(GlideRequestOptions.getInstance().normalRequestOption())
                    .into(((ProductViewHolder) holder).image_product);

            //点击事件
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(holder.itemView, holder.getLayoutPosition(), data);
                    }
                }
            });

            //长按事件
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemLongClick(holder.itemView, holder.getLayoutPosition(), data);
                    }
                    //返回true表示已处理完这个事件
                    return true;
                }
            });
        } else if (holder instanceof HeadViewHolder) {
            ((HeadViewHolder) holder).tv_head.setText((String) datas.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        //根据position返回对应的类型
        if (datas.get(position) instanceof String) {
            return ITEM_HEAD;
        } else {
            return ITEM_PRODUCT;
        }
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        //图片
        public ImageView image_product;
        //名称
        public TextView tv_name;
        //价格
        public TextView tv_price;

        public ProductViewHolder(View itemView) {
            super(itemView);
            image_product = (ImageView) itemView.findViewById(R.id.image_product);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);
        }
    }

    public class HeadViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_head;

        public HeadViewHolder(View itemView) {
            super(itemView);
            tv_head = (TextView) itemView.findViewById(R.id.tv_head);
        }
    }

    /**
     * 添加数据
     */
    public void addData(List<BeanProduct> data) {
        for (int i = 0; i < data.size(); i++) {
            BeanProduct product = data.get(i);
            datas.add(product.getTitle());
            datas.addAll(product.getBeanProductList());
        }
        notifyDataSetChanged();
    }

    /**
     * 清除数据
     */
    public void clearData() {
        this.datas.clear();
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        //点击事件
        void onItemClick(View view, int position, BeanProduct.BeanData data);

        //长按
        void onItemLongClick(View view, int position, BeanProduct.BeanData data);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
