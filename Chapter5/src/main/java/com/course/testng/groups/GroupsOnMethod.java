package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {
    @Test(groups ="server")
    public void test1(){
        System.out.println("这是服务端组的测试方法111");
    }

    @Test(groups ="server")
    public void test2(){
        System.out.println("这是服务端组的测试方法222");
    }

    @Test(groups ="client")
    public void test3(){
        System.out.println("这是客户端组的测试方法333");
    }

    @Test(groups ="client")
    public void test4(){
        System.out.println("这是客户端组的测试方法4444");
    }

    @BeforeGroups("server")
    public void beforeGoupsOnServer(){
        System.out.println("这是服务端组运行之前运行的方法");
    }

    @AfterGroups("server")
    public void afterGoupsOnServer(){
        System.out.println("这是服务端组运行之后运行的方法");
    }

    @BeforeGroups("client")
    public void beforeGoupsOnCient(){
        System.out.println("这是客户端组运行之前运行的方法");
    }

    @AfterGroups("client")
    public void afterGoupsOnClient(){
        System.out.println("这是客户端组运行之后运行的方法");
    }
}
