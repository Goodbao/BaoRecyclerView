package com.bao.baorecyclerview.bean;

import java.util.List;

/**
 * 商品类
 */
public class BeanProduct {
    //标题
    private String title;
    private List<BeanData> beanProductList;

    public BeanProduct(String title, List<BeanData> beanProductList) {
        this.title = title;
        this.beanProductList = beanProductList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<BeanData> getBeanProductList() {
        return beanProductList;
    }

    public void setBeanProductList(List<BeanData> beanProductList) {
        this.beanProductList = beanProductList;
    }

    public static class BeanData {
        //商品图片
        private String image;
        //名称
        private String name;
        //价格
        private String price;

        public BeanData(String image, String name, String price) {
            this.image = image;
            this.name = name;
            this.price = price;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}
