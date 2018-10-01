package com.retryfailedtests;

import org.testng.annotations.Test;

public class SampleTestClass2 {
    @Test
    public void thirdTest(){
        System.out.println("My Third Test");

        // Test Code
    }

    @Test
    public void forthTest(){
        int i = 1/0;
        System.out.println("My Forth Test");

        //Test Code
    }
}
