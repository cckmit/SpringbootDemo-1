package com.example.springbootdemo.scheduled.bean;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-07-16
 **/
public class ProductSkuDTO implements Serializable {

    /**
     * id
     */
    @NotNull
    private Long id;
    @NotNull
    private Long productSkuId;
    @NotNull
    private Long  productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
