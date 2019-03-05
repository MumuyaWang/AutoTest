package com.course.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
                return "恭喜你访问成功";
            }
        }
        return "你必须携带cookies信息来";
    }
}
