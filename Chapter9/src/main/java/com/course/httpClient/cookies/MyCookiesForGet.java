package com.course.httpClient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {

    private String url;
    private ResourceBundle bundle;
    //用来存储cookies信息的变量
    private CookieStore store;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application",Locale.CHINA);    //获取配置文件，在resources文件下
        url= bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        //配置文件中拼接测试的url
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url + uri;
        //测试逻辑代码书写
        CookieStore cookieStore = new BasicCookieStore();   //修改了
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();   //修改了
        //HttpClient client = new DefaultHttpClient();      //过时
        //HttpClient client = HttpClients.createDefault();   //也不好用

        HttpGet get = new HttpGet(testUrl);
        //HttpClient client = HttpClients.createDefault();
        HttpResponse response = httpClient.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //获取cookies信息
        //CookieStore store =client.getCookieStore();    高版本不支持
        //List<Cookie> cookieList = store.getCookies();  高版本不支持

        this.store = cookieStore;
        List<Cookie> cookieList = cookieStore.getCookies();
        for (Cookie cookie:cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name = "+name+",cookie value = "+ value);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    //依赖testGetCookies方法
    public void testGetWithCookies() throws IOException {
        String uri = bundle.getString("test.get.with.cookies");
        String testUrl = this.url + uri;   //获取测试地址
        HttpGet get = new HttpGet(testUrl);

        //设置cookies信息
        CookieStore cookieStore = this.store;
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();   //修改了
        HttpResponse response = httpClient.execute(get);

        //获取相应的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode = "+ statusCode);

        if(statusCode == 200){
            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }
    }
}