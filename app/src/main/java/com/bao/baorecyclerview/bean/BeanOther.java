package com.bao.baorecyclerview.bean;


public class BeanOther {
    private String image;
    private String name;

    public BeanOther(String image, String name) {

        this.image = image;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {

        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
