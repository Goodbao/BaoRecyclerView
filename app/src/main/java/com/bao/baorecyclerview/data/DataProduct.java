package com.bao.baorecyclerview.data;

import com.bao.baorecyclerview.bean.BeanProduct;

import java.util.ArrayList;
import java.util.List;


public class DataProduct {
    public static List<BeanProduct> getProductList() {
        List<BeanProduct> productList = new ArrayList<>();


        List<BeanProduct.BeanData> dataList1 = new ArrayList<>();
        dataList1.add(new BeanProduct.BeanData("https://images.pexels.com/photos/462678/pexels-photo-462678.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb", "球拍", "100"));
        dataList1.add(new BeanProduct.BeanData("https://images.pexels.com/photos/448835/pexels-photo-448835.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb", "书", "50"));
        dataList1.add(new BeanProduct.BeanData("https://images.pexels.com/photos/450035/pexels-photo-450035.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb", "电脑", "6000"));
        dataList1.add(new BeanProduct.BeanData("https://images.pexels.com/photos/457882/pexels-photo-457882.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb", "树", "8000"));
        BeanProduct product1 = new BeanProduct("商品头部1", dataList1);


        List<BeanProduct.BeanData> dataList2 = new ArrayList<>();
        dataList2.add(new BeanProduct.BeanData("https://images.pexels.com/photos/462671/pexels-photo-462671.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb", "双子塔", "1000000000"));
        dataList2.add(new BeanProduct.BeanData("https://images.pexels.com/photos/436779/pexels-photo-436779.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb", "皮", "100"));
        dataList2.add(new BeanProduct.BeanData("https://images.pexels.com/photos/440589/pexels-photo-440589.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb", "桌球", "200"));
        dataList2.add(new BeanProduct.BeanData("https://images.pexels.com/photos/442587/pexels-photo-442587.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb", "无人机", "8000"));
        dataList2.add(new BeanProduct.BeanData("https://images.pexels.com/photos/450109/pexels-photo-450109.jpeg?h=350&auto=compress&cs=tinysrgb", "指尖陀螺", "100"));
        BeanProduct product2 = new BeanProduct("商品头部2", dataList2);


        productList.add(product1);
        productList.add(product2);
        return productList;
    }
}
