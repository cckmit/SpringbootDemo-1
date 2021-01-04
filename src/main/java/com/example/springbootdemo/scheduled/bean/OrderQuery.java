package com.example.springbootdemo.scheduled.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author lidengfeng
 * @date 2019/09/10
 **/

public class OrderQuery implements Serializable {

    /**
     * 姓名
     */
    private String contact;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 5，待发货，30，已出库 10，待结账 7，已完成 8,已取消
     * 状态
     */
    private Byte state;

    /**
     * 店铺id
     */
    private String shopId;


    /**
     * 店铺id集合
     */
    private List<String> shopIdList;

    /**
     * 客户经理手机号
     */
    private String mobileNo;

    /**
     * 经销商类型
     */
    private Integer dealerType;
    /**
     * 手机号
     */
    private String phone;

    /**
     * 查询参数
     */
    private String searchWord;

    /**
     * 第三方物流编号
     */
    private String orderLogisticsId;

    /**
     * 1 今日 2七天
     */
    private Integer timeType;

    /**
     * 时间范围开始时间
     */
    private String orderCreateStartTime;

    public String getOrderCreateStartTime() {
        return orderCreateStartTime;
    }

    public void setOrderCreateStartTime(String orderCreateStartTime) {
        this.orderCreateStartTime = orderCreateStartTime;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public List<String> getShopIdList() {
        return shopIdList;
    }

    public void setShopIdList(List<String> shopIdList) {
        this.shopIdList = shopIdList;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Integer getDealerType() {
        return dealerType;
    }

    public void setDealerType(Integer dealerType) {
        this.dealerType = dealerType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public String getOrderLogisticsId() {
        return orderLogisticsId;
    }

    public void setOrderLogisticsId(String orderLogisticsId) {
        this.orderLogisticsId = orderLogisticsId;
    }

    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }
}
