package com.bao.baorecyclerview.bean;

import java.util.List;


public class BeanDetail {
    private String image_head;
    private String image_designer;
    private String image_video;

    private List<BeanImage> beanImageList;

    private List<BeanProduct> productList;

    private List<BeanOther> otherList;

    public BeanDetail() {
    }

    public BeanDetail(String image_head, String image_designer, String image_video, List<BeanImage> beanImageList, List<BeanProduct> productList, List<BeanOther> otherList) {
        this.image_head = image_head;
        this.image_designer = image_designer;
        this.image_video = image_video;
        this.beanImageList = beanImageList;
        this.productList = productList;
        this.otherList = otherList;
    }

    public String getImage_head() {
        return image_head;
    }

    public void setImage_head(String image_head) {
        this.image_head = image_head;
    }

    public String getImage_designer() {
        return image_designer;
    }

    public void setImage_designer(String image_designer) {
        this.image_designer = image_designer;
    }

    public String getImage_video() {
        return image_video;
    }

    public void setImage_video(String image_video) {
        this.image_video = image_video;
    }

    public List<BeanImage> getBeanImageList() {
        return beanImageList;
    }

    public void setBeanImageList(List<BeanImage> beanImageList) {
        this.beanImageList = beanImageList;
    }

    public List<BeanProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<BeanProduct> productList) {
        this.productList = productList;
    }

    public List<BeanOther> getOtherList() {
        return otherList;
    }

    public void setOtherList(List<BeanOther> otherList) {
        this.otherList = otherList;
    }
}
