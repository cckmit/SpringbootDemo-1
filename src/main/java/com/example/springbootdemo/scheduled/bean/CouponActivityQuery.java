/**
 * Copyright © 2017 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.example.springbootdemo.scheduled.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 优惠券活动查询
 */
public class CouponActivityQuery implements Serializable{

    @Override
    public String toString() {
        return "CouponActivityQuery{" +
                "couponActivityId='" + couponActivityId + '\'' +
                ", state=" + state +
                ", states=" + states +
                ", assignProductCoupon=" + assignProductCoupon +
                ", activityExpired=" + activityExpired +
                ", couponExpired=" + couponExpired +
                ", couponType=" + couponType +
                ", couponName='" + couponName + '\'' +
                ", beginDate='" + beginDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", shopId=" + shopId +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }

    /**
     * 优惠券活动id
     */
    private String couponActivityId;

    /**
     * 状态 0-待发布(未发布)，2-已发布(活动中)，3-已下架(已结束),4-未开始
     */
    private Integer state;


    /**
     * 查询状态的集合状态 0-待发布，2-已发布，3-已下架
     */
    private List<Integer> states;

    /**
     * 是否查看定向产品卷活动
     */
    private boolean assignProductCoupon;

    /**
     * 是否查询出过期活动
     */
    private boolean activityExpired;


    /**
     * 是否查询出过期优惠券
     */
    private boolean couponExpired;

    /**
     * 券类型 0-通用券,1-定向产品券
     */
    private Integer couponType;

    /**
     * 券名称
     */
    private String couponName;

    /**
     * 优惠券活动开始日期
     */
    private String beginDate;

    /**
     * 优惠券活动结束日期
     */
    private String endDate;

    /**
     * 店铺Id
     */
    private Long shopId;


    /**
     * 页码
     */
    private Integer pageNum;


    /**
     * 每页的数量
     */
    private Integer pageSize;


    /**
     * 获取 优惠券活动id
     * @return
     */
    public String getCouponActivityId() {
        return couponActivityId;
    }

    /**
     * 设置 优惠券活动id
     * @param couponActivityId
     */
    public void setCouponActivityId(String couponActivityId) {
        this.couponActivityId = couponActivityId;
    }




    /**
     * 获取 状态 0-待发布，2-已发布，3-已下架
     *
     * @return state 状态 0-待发布，2-已发布，3-已下架
     */
    public Integer getState() {
        return this.state;
    }

    /**
     * 设置 状态 0-待发布，2-已发布，3-已下架
     *
     * @param state 状态 0-待发布，2-已发布，3-已下架
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取 是否查看定向产品卷活动
     *
     * @return assignProductCoupon 是否查看定向产品卷活动
     */
    public boolean getAssignProductCoupon() {
        return this.assignProductCoupon;
    }

    /**
     * 设置 是否查看定向产品卷活动
     *
     * @param assignProductCoupon 是否查看定向产品卷活动
     */
    public void setAssignProductCoupon(boolean assignProductCoupon) {
        this.assignProductCoupon = assignProductCoupon;
    }

    public Integer getCouponType() {
        return couponType;
    }

    public void setCouponType(Integer couponType) {
        this.couponType = couponType;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isActivityExpired() {
        return activityExpired;
    }

    public void setActivityExpired(boolean activityExpired) {
        this.activityExpired = activityExpired;
    }

    public boolean isCouponExpired() {
        return couponExpired;
    }

    public void setCouponExpired(boolean couponExpired) {
        this.couponExpired = couponExpired;
    }

    public List<Integer> getStates() {
        return states;
    }

    public void setStates(List<Integer> states) {
        this.states = states;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
