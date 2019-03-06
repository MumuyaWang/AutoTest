package com.course.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@RestController   //我是需要被扫描的类
public class MyGetMethod {
    /**
     * 10-3 返回cookies信息的get接口开发
     */
    @RequestMapping(value="/getCookies",method = RequestMethod.GET)     //访问路径，使用RequestMethod.GET这种方法访问
    public String getCookies(HttpServletResponse response){
        //HttpServerLetRequest装请求信息的类
        //HttpServerLetResponse装响应信息的类
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);     //添加cookie
        return "恭喜你获取cookies成功";
    }

    /**
     * 10-4 一个要求携带cookies信息访问的get接口开发
     * 要求客户端携带cookies访问
     * 这是一个需要携带cookies信息访问的get接口开发
     * */
    @RequestMapping(value="/get/with/cookies",method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies =request.getCookies();
        if(Objects.isNull(cookies)){
            return "你必须携带cookies信息来";
        }
        for(Cookie cookie: cookies){
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "这是一个需要携带cookies信息才能访问的get请求";
            }
        }
        return "你必须携带cookies信息来";
    }

    /**
     * 开发一个需要携带参数才能访问的get请求
     * 第一种实现方式  url : key = value & key = value
     * 我们来模拟获取商品列表
     * */
    @RequestMapping(value ="/get/with/param",method =RequestMethod.GET )
    public Map<String,Integer> getList(@RequestParam Integer start, @RequestParam Integer end){
        Map<String ,Integer> myList = new HashMap<>();
        myList.put("鞋",400);
        myList.put("干脆面",1);
        myList.put("衬衫",200);
        return myList;
    }

    /**
     * 第二种需要携带参数访问的get请求
     * url:ip:port/get/with/param/10/20
     * */
    @RequestMapping(value ="/get/with/param/{start}/{end}" )
    public Map<String,Integer> mygetList(@RequestParam Integer start, @RequestParam Integer end){
        Map<String ,Integer> myList = new HashMap<>();
        myList.put("鞋",400);
        myList.put("干脆面",1);
        myList.put("衬衫",200);
        return myList;
    }

}
