package com.example.springbootdemo.scheduled.bean;

import java.io.Serializable;

/**
 * 类目统计分组
 * @author lidengfeng
 * @date 2019/12/31
 **/

public class StatisticalGroupDTO implements Serializable {


    /**
     * 类目统计分组id
     */
    private Integer  statisticalGroup;


    /**
     * 统计分组名称
     */
    private String  groupName;


    public Integer getStatisticalGroup() {
        return statisticalGroup;
    }

    public void setStatisticalGroup(Integer statisticalGroup) {
        this.statisticalGroup = statisticalGroup;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
