package com.bao.baorecyclerview.data;

import com.bao.baorecyclerview.bean.BeanImage;

import java.util.ArrayList;
import java.util.List;


public class
DataImage {
    public static List<String> getImageList() {
        List<String> imageList = new ArrayList<>();

        imageList.add("https://images.pexels.com/photos/407293/pexels-photo-407293.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb");
        imageList.add("https://images.pexels.com/photos/407294/pexels-photo-407294.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb");
        imageList.add("https://images.pexels.com/photos/411592/pexels-photo-411592.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb");
        imageList.add("https://images.pexels.com/photos/418296/pexels-photo-418296.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb");
        imageList.add("https://images.pexels.com/photos/412201/pexels-photo-412201.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb");
        imageList.add("https://images.pexels.com/photos/418281/pexels-photo-418281.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb");
        imageList.add("https://images.pexels.com/photos/428062/pexels-photo-428062.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb");
        imageList.add("https://images.pexels.com/photos/569098/pexels-photo-569098.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb");
        imageList.add("https://images.pexels.com/photos/423366/pexels-photo-423366.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb");
        imageList.add("https://images.pexels.com/photos/426791/pexels-photo-426791.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb");


        return imageList;
    }

    public static List<BeanImage> getBeanImageList() {
        List<BeanImage> imageList = new ArrayList<>();

        imageList.add(new BeanImage("https://images.pexels.com/photos/407293/pexels-photo-407293.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb"));
        imageList.add(new BeanImage("https://images.pexels.com/photos/407294/pexels-photo-407294.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb"));
        imageList.add(new BeanImage("https://images.pexels.com/photos/411592/pexels-photo-411592.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb"));
        imageList.add(new BeanImage("https://images.pexels.com/photos/418296/pexels-photo-418296.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb"));
        imageList.add(new BeanImage("https://images.pexels.com/photos/412201/pexels-photo-412201.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb"));
        imageList.add(new BeanImage("https://images.pexels.com/photos/418281/pexels-photo-418281.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb"));
        imageList.add(new BeanImage("https://images.pexels.com/photos/428062/pexels-photo-428062.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb"));
        imageList.add(new BeanImage("https://images.pexels.com/photos/569098/pexels-photo-569098.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb"));
        imageList.add(new BeanImage("https://images.pexels.com/photos/423366/pexels-photo-423366.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb"));
        imageList.add(new BeanImage("https://images.pexels.com/photos/426791/pexels-photo-426791.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb"));


        return imageList;
    }
}