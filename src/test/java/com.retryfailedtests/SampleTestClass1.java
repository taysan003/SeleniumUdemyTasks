package com.retryfailedtests;

import org.testng.annotations.Test;

public class SampleTestClass1 {
    @Test
    public void firstTest(){
        System.out.println("My First Test");
    }

    @Test
    public void secondTest(){
        int i = 1/0;
        System.out.println("My second Test");
    }
}
