package com.course.testng;

import org.testng.annotations.Test;

public class DenpendTest {

    @Test
    public void test1(){
        System.out.println("test run1");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test run2");
    }
}
