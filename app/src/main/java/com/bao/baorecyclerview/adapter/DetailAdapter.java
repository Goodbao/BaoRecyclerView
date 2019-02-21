package com.bao.baorecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bao.baorecyclerview.R;
import com.bao.baorecyclerview.bean.BeanDetail;
import com.bao.baorecyclerview.bean.BeanImage;
import com.bao.baorecyclerview.bean.BeanOther;
import com.bao.baorecyclerview.bean.BeanProduct;
import com.bao.baorecyclerview.utils.GlideRequestOptions;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * 复制型的Adapter
 */

public class DetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //头部
    public static final int ITEM_HEAD = 0;
    //信息
    public static final int ITEM_MESSAGE = 1;
    //图片
    public static final int ITEM_IMAGE = 2;
    //商品头部
    public static final int ITEM_PRODUCT_HEAD = 3;
    //商品
    public static final int ITEM_PRODUCT = 4;
    //其他系列
    public static final int ITEM_OTHER = 5;

    private Context context;
    private List<Object> datas = new ArrayList<>();

    public DetailAdapter(Context context) {
        this.context = context;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (ITEM_PRODUCT == getItemViewType(position)) {
                        return 2;
                    } else if (ITEM_OTHER == getItemViewType(position)) {
                        return 3;
                    } else {
                        return 6;
                    }
                }
            });
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_HEAD) {
            return new HeadViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_head, parent, false));
        } else if (viewType == ITEM_MESSAGE) {
            return new MessageViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_message_1, parent, false));
        } else if (viewType == ITEM_IMAGE) {
            return new ImageViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_image, parent, false));
        } else if (viewType == ITEM_PRODUCT_HEAD) {
            return new ProductHeadViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_head_tv, parent, false));
        } else if (viewType == ITEM_PRODUCT) {
            return new ProductViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_product, parent, false));
        } else if (viewType == ITEM_OTHER) {
            return new OtherViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_other, parent, false));
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //头部
        if (holder instanceof HeadViewHolder) {
            BeanDetail beanDetail = (BeanDetail) datas.get(position);
            Glide.with(context)
                    .load(beanDetail.getImage_head())
                    .apply(GlideRequestOptions.getInstance().normalRequestOption())
                    .into(((HeadViewHolder) holder).image_head);
        }
        //信息
        else if (holder instanceof MessageViewHolder) {
            BeanDetail beanDetail = (BeanDetail) datas.get(position);

            Glide.with(context)
                    .load(beanDetail.getImage_designer())
                    .apply(GlideRequestOptions.getInstance().circleRequestOption())
                    .into(((MessageViewHolder) holder).imageDesigner);

            Glide.with(context)
                    .load(beanDetail.getImage_video())
                    .apply(GlideRequestOptions.getInstance().normalRequestOption())
                    .into(((MessageViewHolder) holder).imageVideo);
        }
        //图片
        else if (holder instanceof ImageViewHolder) {
            BeanImage image = (BeanImage) datas.get(position);
            Glide.with(context)
                    .load(image.getImage())
                    .apply(GlideRequestOptions.getInstance().normalRequestOption())
                    .into(((ImageViewHolder) holder).image_item);
        }
        //商品头部
        else if (holder instanceof ProductHeadViewHolder) {
            ((ProductHeadViewHolder) holder).tv_head.setText((String) datas.get(position));
        }
        //商品
        else if (holder instanceof ProductViewHolder) {
            BeanProduct.BeanData data = (BeanProduct.BeanData) datas.get(position);
            ((ProductViewHolder) holder).tv_name.setText(data.getName());
            ((ProductViewHolder) holder).tv_price.setText(data.getPrice());

            Glide.with(context)
                    .load(data.getImage())
                    .apply(GlideRequestOptions.getInstance().normalRequestOption())
                    .into(((ProductViewHolder) holder).image_product);
        }
        //其他
        else if (holder instanceof OtherViewHolder) {
            BeanOther other = (BeanOther) datas.get(position);

            Glide.with(context)
                    .load(other.getImage())
                    .apply(GlideRequestOptions.getInstance().normalRequestOption())
                    .into(((OtherViewHolder) holder).image_other);
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            //确定第一个是头部
            return ITEM_HEAD;
        } else if (position == 1) {
            //确定第二个是信息
            return ITEM_MESSAGE;
        } else if (datas.get(position) instanceof BeanImage) {
            return ITEM_IMAGE;
        } else if (datas.get(position) instanceof BeanProduct.BeanData) {
            return ITEM_PRODUCT;
        } else if (datas.get(position) instanceof BeanOther) {
            return ITEM_OTHER;
        } else {
            //确定String用户商品头部
            return ITEM_PRODUCT_HEAD;
        }
    }

    /**
     * 头部
     */
    public class HeadViewHolder extends RecyclerView.ViewHolder {
        public ImageView image_head;

        public HeadViewHolder(View itemView) {
            super(itemView);
            image_head = (ImageView) itemView.findViewById(R.id.image_head);
        }
    }

    /**
     * 信息
     */
    public class MessageViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageDesigner;
        public TextView tvDesigner;
        public RelativeLayout rlDesigner;
        public TextView tvDescription;
        public LinearLayout llDescription;
        public ImageView imageVideo;

        public MessageViewHolder(View itemView) {
            super(itemView);
            imageDesigner = (ImageView) itemView.findViewById(R.id.image_designer);
            tvDesigner = (TextView) itemView.findViewById(R.id.tv_designer);
            rlDesigner = (RelativeLayout) itemView.findViewById(R.id.rl_designer);
            tvDescription = (TextView) itemView.findViewById(R.id.tv_description);
            llDescription = (LinearLayout) itemView.findViewById(R.id.ll_description);
            imageVideo = (ImageView) itemView.findViewById(R.id.image_video);
        }
    }

    /**
     * 图片
     */
    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public ImageView image_item;

        public ImageViewHolder(View itemView) {
            super(itemView);
            image_item = (ImageView) itemView.findViewById(R.id.image_item);
        }
    }

    /**
     * 商品头部
     */
    public class ProductHeadViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_head;

        public ProductHeadViewHolder(View itemView) {
            super(itemView);
            tv_head = (TextView) itemView.findViewById(R.id.tv_head);
        }
    }

    /**
     * 商品
     */
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

    /**
     * 其他
     */
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
    public void addData(BeanDetail detail) {
        //确定前两个的数据，就可以这样写
        datas.add(detail);
        datas.add(detail);
        //图片
        datas.addAll(detail.getBeanImageList());
        //商品
        for (int i = 0; i < detail.getProductList().size(); i++) {
            BeanProduct product = detail.getProductList().get(i);
            datas.add(product.getTitle());
            datas.addAll(product.getBeanProductList());
        }
        //其他系列
        datas.addAll(detail.getOtherList());
        notifyDataSetChanged();
    }

    /**
     * 添加数据
     */
    public void addData(List<BeanOther> others) {
        datas.addAll(others);
        notifyDataSetChanged();
    }

    /**
     * 清除数据
     */
    public void clearData() {
        datas.clear();
        notifyDataSetChanged();
    }
}