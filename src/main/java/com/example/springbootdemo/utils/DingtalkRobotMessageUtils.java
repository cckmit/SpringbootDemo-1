package com.example.springbootdemo.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @program: easysale-saas
 * @description: 钉钉机器人消息推送
 * @author: swd
 * @create: 2020-06-18
 **/
@Component
public class DingtalkRobotMessageUtils {

    private static final Logger logger = LoggerFactory.getLogger(DingtalkRobotMessageUtils.class);


    private static final String ACCESS_TOKEN = "5cc963c5d5e5b7a7e9adf11579e7aee1d62d549a9a4bac0fb608c522d354fd8e";

    @Resource
    private RestTemplate resTemplate;

    private static RestTemplate restTemplate;

    @PostConstruct
    public void init() {
        restTemplate = this.resTemplate;
    }



    /**
     * 发送消息
     *
     * @param msg
     * @return
     */
    public static void sendDingtalkRobotMessageText(String msg) {
            //封装格式
            JSONObject content = new JSONObject();
            JSONObject text = new JSONObject();
            content.put("msgtype","text");
            text.put("content",String.format("%s：%s","易经销",msg));
            content.put("text",text);
            sendDingtalkRobotMessage(content);
    }


    /**
     * 发送消息
     *
     * @param msg
     * @return
     */
    public static void sendDingtalkRobotMessageMarkdown(String title,String msg) {
        //封装格式
        JSONObject content = new JSONObject();
        JSONObject markdown = new JSONObject();
        content.put("msgtype","markdown");
        markdown.put("title",String.format("%s：","易经销"));
        markdown.put("text",String.format("#### "+title+"\n" +
                "> "+msg+"\n\n"));
        content.put("markdown",markdown);
        sendDingtalkRobotMessage(content);
        
    }

    private static void sendDingtalkRobotMessage(final JSONObject content){
        try {
            // 获取到服务器中的access_tocken
            String requestUrl = String.format("https://oapi.dingtalk.com/robot/send?access_token=%s",ACCESS_TOKEN);
            logger.info("发送统一模板消息到:{}",requestUrl);
            //RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            // 请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            logger.info("发送统一模板消息:{}",content);
            HttpEntity<String> requestEntity = new HttpEntity<String>(content.toJSONString(), headers);

            // 进行网络请求,访问url接口
            ResponseEntity<String> responseEntity = restTemplate.exchange(requestUrl, HttpMethod.POST, requestEntity, String.class);
            logger.info("发送统一模板消息后接受数据:{}",responseEntity);
        } catch (Exception e) {
            logger.info("DingtalkRobotMessage推送失败:{}",e.getMessage());
        }
    }

}
