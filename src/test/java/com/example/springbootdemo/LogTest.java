package com.example.springbootdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-08-05
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogTest {

    //与@Slf4j效果一样
    //private static final Logger log = LoggerFactory.getLogger(LogTest.class);

    /**
     * trace<debug<info<warn<error
     */
    @Test
    public void test01() {
        log.trace("");
        log.debug("测试信息");
        log.info("普通信息");
        log.warn("警告进行");
        log.error("错误信息");
    }

    /**
     * trace<debug<info<warn<error
     */
    @Test
    public void test02() {
        String contentStr = "您好，您的经销商登录账户已经合并到%s手机号，请知晓！！！";
        String formattingParametersStr = "18062303627";
        List<String> content = new ArrayList<>(Arrays.asList(contentStr.split("%s")));
        List<String> formatting = new ArrayList<>(Arrays.asList(formattingParametersStr.split("%t")));
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < content.size(); i++) {
            if (i==content.size()-1){
                sb.append(content.get(i));
            }else {
                sb.append(content.get(i).concat(formatting.get(i)));
            }
        }
        log.info(sb.toString());

    }
}
