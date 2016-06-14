package com.koumanwei.enjoy.bean;

/**
 * Created by koumanwei on 2016-05-24.
 */

/**
 * girdView填充数据bean
 */
public class GridData {
    private int image;
    private String text;

    public GridData(int image, String text) {
        this.image = image;
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
