package com.example.springbootdemo.scheduled.bean;

import java.io.Serializable;

/**
 * 区域产品信息审核消息体
 *
 * @author liuzhihao
 * @since 2020/5/8
 */
public class ShopProductInfoAuditMessage implements Serializable {

    /**
     * 产品信息id
     */
    private Integer productInfoId;

    /**
     * 产品信息状态
     */
    private Integer productInfoState;

    /**
     * 操作人id
     */
    private Integer optUserId;

    /**
     * 审核拒绝原因
     */
    private String rejectReason;




    /**
     * 获取 产品信息id
     *
     * @return productInfoId 产品信息id
     */
    public Integer getProductInfoId() {
        return this.productInfoId;
    }

    /**
     * 设置 产品信息id
     *
     * @param productInfoId 产品信息id
     */
    public void setProductInfoId(Integer productInfoId) {
        this.productInfoId = productInfoId;
    }

    /**
     * 获取 产品信息状态
     *
     * @return productInfoState 产品信息状态
     */
    public Integer getProductInfoState() {
        return this.productInfoState;
    }

    /**
     * 设置 产品信息状态
     *
     * @param productInfoState 产品信息状态
     */
    public void setProductInfoState(Integer productInfoState) {
        this.productInfoState = productInfoState;
    }

    /**
     * 获取 操作人id
     *
     * @return optUserId 操作人id
     */
    public Integer getOptUserId() {
        return this.optUserId;
    }

    /**
     * 设置 操作人id
     *
     * @param optUserId 操作人id
     */
    public void setOptUserId(Integer optUserId) {
        this.optUserId = optUserId;
    }

    /**
     * 获取 审核拒绝原因
     *
     * @return rejectReason 审核拒绝原因
     */
    public String getRejectReason() {
        return this.rejectReason;
    }

    /**
     * 设置 审核拒绝原因
     *
     * @param rejectReason 审核拒绝原因
     */
    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }


}
