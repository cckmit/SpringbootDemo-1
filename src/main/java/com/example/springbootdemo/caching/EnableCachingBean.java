package com.example.springbootdemo.caching;

import java.io.Serializable;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-08-19
 **/
public class EnableCachingBean implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private String id;
    /**
     * 易经销店铺ID
     */
    private String shopId;
    /**
     * 交易店铺ID
     */
    private String jpShopId;
    /**
     * 交易店铺名称
     */
    private String jpShopName;
    /**
     * 状态  0禁用  1启用
     */
    private Integer state;

    private Integer state1;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getJpShopId() {
        return jpShopId;
    }

    public void setJpShopId(String jpShopId) {
        this.jpShopId = jpShopId;
    }

    public String getJpShopName() {
        return jpShopName;
    }

    public void setJpShopName(String jpShopName) {
        this.jpShopName = jpShopName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
        this.state1 = state;
    }
}
