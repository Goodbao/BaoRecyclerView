package com.bao.baorecyclerview.utils;

import com.bao.baorecyclerview.R;
import com.bumptech.glide.request.RequestOptions;

/**
 * Glide4.0版本，设置错误图片，默认图片，设置圆形图等方法要用 RequestOptions
 */
public class GlideRequestOptions {
    private RequestOptions requestOptions;
    private RequestOptions requestOptionsCircle;

    private static GlideRequestOptions instance;

    public static GlideRequestOptions getInstance() {
        if (instance == null) {
            synchronized (GlideRequestOptions.class) {
                if (instance == null) {
                    instance = new GlideRequestOptions();
                }
            }
        }
        return instance;
    }

    /**
     * 默认
     */
    public RequestOptions normalRequestOption() {
        if (requestOptions == null) {
            requestOptions = new RequestOptions()
                    .error(R.drawable.ic_image)//错误加载的图片
                    .placeholder(R.drawable.ic_image);//默认图片
        }
        return requestOptions;
    }

    /**
     * 圆形
     */
    public RequestOptions circleRequestOption() {
        if (requestOptionsCircle == null) {
            requestOptionsCircle = new RequestOptions()
                    .error(R.drawable.ic_image)
                    .placeholder(R.drawable.ic_image)
                    .transform(new GlideCircleTransform());//设置为圆图
        }
        return requestOptionsCircle;
    }
}
