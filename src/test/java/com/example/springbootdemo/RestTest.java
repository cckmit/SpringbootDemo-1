package com.example.springbootdemo;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import okhttp3.MediaType;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2021-01-08
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTest {

    @Resource
    private RestTemplate restTemplate;

    @Test
    public void test01() throws IOException {
        File file = new File("C:\\Users\\shuwending\\Desktop\\bd3e701e1d7f494b97a5093679094a6a.pdf");
        // 构建请求
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url("http://yjp-product-1301864755.cos.ap-beijing.myqcloud.com/2021/01/08/bd3e701e1d7f494b97a5093679094a6a.pdf");
        requestBuilder.header("Authorization", "q-sign-algorithm=sha1&q-ak=AKIDyqUfdMRHfsphhYbsz3wc2LWTBiE3rFbu&q-sign-time=1610085787;1610087587&q-key-time=1610085787;1610087587&q-header-list=&q-url-param-list=&q-signature=0609a41f7b7752a766026938b5dc37b088c30930");
        // 构造请求体
        MediaType mediaType = MediaType.parse("application/pdf");
        RequestBody requestBody = RequestBody.create(mediaType, getFileByteArray(file));
        requestBuilder.post(requestBody);

        // 执行上传请求
        Request request = requestBuilder.put(requestBody).build();
        OkHttpClient httpClient = new OkHttpClient();
        Call call = httpClient.newCall(request);
        try (Response execute = call.execute()) {
            System.out.println(execute);
        }
    }


    @Test
    public void test02() throws IOException {
        File file = new File("C:\\Users\\shuwending\\Pictures\\Camera Roll\\edf25180ff3ea6a76ff94e498942091e.jpeg");
        // 构建请求

        Map<String, String> additionalHeaders = new HashMap<>();
        additionalHeaders.put("Authorization", "q-sign-algorithm=sha1&q-ak=AKIDyqUfdMRHfsphhYbsz3wc2LWTBiE3rFbu&q-sign-time=1610516625;1610518425&q-key-time=1610516625;1610518425&q-header-list=&q-url-param-list=&q-signature=94db1bfb32dec301b13430681be21dcba31d98b4");
        String url = "http://yjp-product-1301864755.cos.ap-beijing.myqcloud.com/2021/01/13/file.jpeg";
        // 构造请求体
        String mediaType = "image/jpeg";

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.parseMediaType(mediaType));
        headers.setAll(additionalHeaders);
        HttpEntity<byte[]> requestUpdate = new HttpEntity<>(getFileByteArray(file),headers);
        ResponseEntity<Void> exchange = restTemplate.exchange(url, HttpMethod.PUT, requestUpdate, Void.class);
        System.out.println(JSON.toJSONString(exchange));
        System.out.println(exchange.getStatusCode().is2xxSuccessful());
    }


    private byte[] getFileByteArray(File file) {
        long fileSize = file.length();
        if (fileSize > Integer.MAX_VALUE) {
            System.out.println("file too big...");
            return null;
        }
        byte[] buffer = null;
        try (FileInputStream fi = new FileInputStream(file)) {
            buffer = new byte[(int) fileSize];
            int offset = 0;
            int numRead = 0;
            while (offset < buffer.length
                    && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
                offset += numRead;
            }
            // 确保所有数据均被读取
            if (offset != buffer.length) {
                throw new IOException("Could not completely read file "
                        + file.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer;
    }
}
