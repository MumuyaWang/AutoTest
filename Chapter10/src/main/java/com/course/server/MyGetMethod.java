package com.course.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@RestController   //我是需要被扫描的类
public class MyGetMethod {
    @RequestMapping(value="/getCookies",method = RequestMethod.GET)     //访问路径，使用RequestMethod.GET这种方法访问
    public String getCookies(HttpServletResponse response){
        //HttpServerLetRequest装请求信息的类
        //HttpServerLetResponse装响应信息的类
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);     //添加cookie
        return "恭喜你获取cookies成功";
    }
}
