package com.bao.baorecyclerview.data;


import com.bao.baorecyclerview.bean.BeanDetail;

/**
 * 模拟数据
 */
public class DataDetail {
    public static BeanDetail getData() {
        BeanDetail detail = new BeanDetail();
        detail.setImage_head("https://images.pexels.com/photos/428124/pexels-photo-428124.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb");
        detail.setImage_designer("https://images.pexels.com/photos/428336/pexels-photo-428336.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb");
        detail.setImage_video("https://images.pexels.com/photos/428301/pexels-photo-428301.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb");

        detail.setBeanImageList(DataImage.getBeanImageList());
        detail.setProductList(DataProduct.getProductList());
        detail.setOtherList(DataOther.getOtherList());
        return detail;
    }
}
