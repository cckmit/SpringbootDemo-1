package com.example.springbootdemo.bean;

import java.io.Serializable;
import java.util.Map;

/**
 * @program: easysale-saas
 * @description:
 * @author: swd
 * @create: 2021-01-07
 **/
public class AuthorizationResultDTO implements Serializable {

    private static final long serialVersionUID = 9040075235005531224L;
    /**
     * 附加请求头.
     */
    private Map<String,String> additionalHeaders;
    /**
     * 附加参数.
     */
    private Map<String,String>  additionalParams;
    /**
     * 文件URL
     */
    private String url;

    public Map<String, String> getAdditionalHeaders() {
        return additionalHeaders;
    }

    public void setAdditionalHeaders(Map<String, String> additionalHeaders) {
        this.additionalHeaders = additionalHeaders;
    }

    public Map<String, String> getAdditionalParams() {
        return additionalParams;
    }

    public void setAdditionalParams(Map<String, String> additionalParams) {
        this.additionalParams = additionalParams;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
