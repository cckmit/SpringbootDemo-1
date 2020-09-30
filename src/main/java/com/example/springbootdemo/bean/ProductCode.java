package com.example.springbootdemo.bean;


import java.io.Serializable;

/**
 * 箱码 瓶码 或 包装码 封装
 * Created by 杨康 on 2016/10/19.
 */
public class ProductCode implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 瓶码 或 包装码
     */
    private String code;

    /**
     * 箱码
     */
    private String boxCode;
    /**
     * 是否自定义
     */
    private Boolean isCustom;


    /**
     * 图片
     */
    private String image;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getCustom() {
        return isCustom;
    }

    public void setIsCustom(Boolean custom) {
        isCustom = custom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBoxCode() {
        return boxCode;
    }

    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }
}
