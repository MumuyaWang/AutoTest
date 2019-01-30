package com.course.httpClient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;
import java.io.IOException;

public class MyHttpClient {

    @Test
    public void test1() throws IOException {
        //用来存放结果
        String result;
        HttpGet get = new HttpGet("http://www.baidu.com");
        //这是用来执行get方法的
        //HttpClient client = new DefaultHttpClient();      //过时
        HttpClient client = HttpClients.createDefault();
        client.execute(get);
        HttpResponse response = client.execute(get);
        result =EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
    }
}
