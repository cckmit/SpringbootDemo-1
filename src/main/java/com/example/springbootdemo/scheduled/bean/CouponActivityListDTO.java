/**
 * Copyright © 2017 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.example.springbootdemo.scheduled.bean;

import java.io.Serializable;

/**
 *优惠券活动集合
 */
public class CouponActivityListDTO implements Serializable {

    /**
     * 优惠券活动id
     */
    private String couponActivityId;

    /**
     * 优惠券名称
     */
    private String couponName;

    /**
     * 优惠券类型 0-通用券 1-定向产品券
     */
    private Integer couponType;

    /**
     * 活动状态 （0-待发布，2-已发布，3-已下架）
     */
    private Integer state;

    /**
     * 活动开始日期
     */
    private String beginDate;

    /**
     * 活动结束日期
     */
    private String endDate;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 获取 优惠券活动id
     * @return couponActivityId 优惠券活动id
     */
    public String getCouponActivityId() {
        return this.couponActivityId;
    }

    /**
     * 设置 优惠券活动id
     * @param couponActivityId 优惠券活动id
     */
    public void setCouponActivityId(String couponActivityId) {
        this.couponActivityId = couponActivityId;
    }

    /**
     * 获取 活动状态 （0-待发布，2-已发布，3-已下架）
     * @return state 活动状态 （0-待发布，2-已发布，3-已下架）
     */
    public Integer getState() {
        return this.state;
    }

    /**
     * 设置 活动状态 （0-待发布，2-已发布，3-已下架）
     * @param state 活动状态 （0-待发布，2-已发布，3-已下架）
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取 活动开始日期
     * @return beginDate 活动开始日期
     */
    public String getBeginDate() {
        return this.beginDate;
    }

    /**
     * 设置 活动开始日期
     * @param beginDate 活动开始日期
     */
    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    /**
     * 获取 活动结束日期
     * @return endDate 活动结束日期
     */
    public String getEndDate() {
        return this.endDate;
    }

    /**
     * 设置 活动结束日期
     * @param endDate 活动结束日期
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取 优惠券名称
     * @return couponName 优惠券名称
     */
    public String getCouponName() {
        return this.couponName;
    }

    /**
     * 设置 优惠券名称
     * @param couponName 优惠券名称
     */
    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    /**
     * 获取 产品名称
     *
     * @return productName 产品名称
     */
    public String getProductName() {
        return this.productName;
    }

    /**
     * 设置 产品名称
     *
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getCouponType() {
        return couponType;
    }

    public void setCouponType(Integer couponType) {
        this.couponType = couponType;
    }
}
