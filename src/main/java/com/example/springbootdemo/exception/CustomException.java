package com.example.springbootdemo.exception;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-07-30
 **/
public class CustomException extends RuntimeException {

    //可以用来接受我们方法中传的参数
    private String id;

    public CustomException(String id) {
        super("custom not exist");
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
