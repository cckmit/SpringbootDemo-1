package com.example.springbootdemo.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author lidengfeng
 * @date 2020/01/20
 **/
public class SkuPromotionDTO implements Serializable {

    /**
     * 产品skuId
     */
    private String productSkuId;

    /**
     * 开始时间
     */
    private Date beginTime;

    /**
     * 结束时间
     */
    private Date endTime;


    /**
     * 店铺id
     */
    private String shopId;

    /**
     * 区域id集合
     */
    private Set<Integer> regionIdList;


    public String getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(String productSkuId) {
        this.productSkuId = productSkuId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public Set<Integer> getRegionIdList() {
        return regionIdList;
    }

    public void setRegionIdList(Set<Integer> regionIdList) {
        this.regionIdList = regionIdList;
    }
}
