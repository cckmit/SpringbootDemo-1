/*
 * @ClassName DiscountProduct
 * @Description 
 * @version 1.0
 * @Date 2020-01-06 13:37:46
 */
package com.example.springbootdemo.scheduled.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class DiscountProductPO implements Serializable {
    /**
     * id
     */
    private Long id;
    /**
     * 打折活动id
     */
    private Long discountId;
    /**
     * 商品skuid
     */
    private Long productSkuId;
    /**
     * 折扣
     */
    private BigDecimal discountVal;
    /**
     * 减少金额
     */
    private BigDecimal lessAmount;
    /**
     * 折扣后活动金额
     */
    private BigDecimal saleAmount;
    /**
     * 活动价格单位
     */
    private String priceUnit;
    /**
     * 排列顺序
     */
    private Integer sequence;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最新更新时间
     */
    private Date lastUpdateTime;

    /**
     * 限购数量
     */
    private Integer limitCount;

    /**
     * 限购时间间隔
     */
    private Integer limitIntervalDay;

    /**
     * 限购规则名称
     */
    private String limitRuleName;
    /**
     * 限购规则id
     */
    private Integer jpLimitId;

    public Integer getJpLimitId() {
        return jpLimitId;
    }

    public void setJpLimitId(Integer jpLimitId) {
        this.jpLimitId = jpLimitId;
    }

    public Integer getLimitCount() {
        return limitCount;
    }

    public void setLimitCount(Integer limitCount) {
        this.limitCount = limitCount;
    }

    public Integer getLimitIntervalDay() {
        return limitIntervalDay;
    }

    public void setLimitIntervalDay(Integer limitIntervalDay) {
        this.limitIntervalDay = limitIntervalDay;
    }

    public String getLimitRuleName() {
        return limitRuleName;
    }

    public void setLimitRuleName(String limitRuleName) {
        this.limitRuleName = limitRuleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }

    public Long getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    public BigDecimal getDiscountVal() {
        return discountVal;
    }

    public void setDiscountVal(BigDecimal discountVal) {
        this.discountVal = discountVal;
    }

    public BigDecimal getLessAmount() {
        return lessAmount;
    }

    public void setLessAmount(BigDecimal lessAmount) {
        this.lessAmount = lessAmount;
    }

    public BigDecimal getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(BigDecimal saleAmount) {
        this.saleAmount = saleAmount;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}