/**
 * Copyright © 2017 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.example.springbootdemo.enums;

/**
 * 盘点的消息接收
 */
public enum ErpType {

    /**
     * 库存盘点单
     */
    INVENTORY_CHECKLIST(7),



    ;

    private Integer value;

    public Integer getValue() {
        return value;
    }

    ErpType(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
