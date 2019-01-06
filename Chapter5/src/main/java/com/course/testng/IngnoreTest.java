package com.course.testng;

import org.testng.annotations.Test;

public class IngnoreTest {
    @Test
    public void ingnore1(){
        System.out.println("ingnore1 执行！");
    }

    @Test(enabled =false)
    public void ingnore2(){
        System.out.println("ingnore2 执行！");
    }

    @Test(enabled = true)
    public void ingnore3(){
        System.out.println("ingnore3 执行！");
    }
}
