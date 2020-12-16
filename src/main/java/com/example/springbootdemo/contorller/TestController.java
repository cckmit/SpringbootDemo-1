package com.example.springbootdemo.contorller;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo.scheduled.bean.Temp;
import com.example.springbootdemo.scheduled.servicer.YjxJobBase;
import com.example.springbootdemo.service.TestService;
import com.example.springbootdemo.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-07-14
 **/
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

//    @Autowired
//    private ScheduledComponent scheduledComponent;

    @Autowired
    private TestService testService;


    /**
     * 发送特殊消息
     *
     * @return
     */
    @PostMapping(value = "/test02")
    public void sendTsMessage(@RequestBody JSONObject dto) {
        YjxJobBase yjxJobBase = SpringUtils.getBean(dto.getString("beanId"));
        try {
            yjxJobBase.execute(dto.getString("data"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送特殊消息
     *
     * @return
     */
    @PostMapping(value = "/test01")
    public String  test01(@RequestBody Temp dto) {
        return JSONObject.toJSONString(dto);
    }


    @PostMapping(value = "/test03")
    public String  test03(@RequestBody JSONObject object) {
//        log.info(object.toJSONString());
//        scheduledComponent.addTask(object.getLong("num"),object.getDate("date"));
        return FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /**
     * 发送特殊消息
     *
     * @return
     */
    @PostMapping(value = "/test04")
    public String  test04(@RequestBody Temp dto) {
         return testService.testAutoCache(dto);
//        return testService.getToken();
    }


}
