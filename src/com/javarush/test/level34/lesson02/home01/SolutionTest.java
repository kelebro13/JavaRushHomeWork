package com.javarush.test.level34.lesson02.home01;

import junit.framework.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by testim on 24.05.16.
 */
public class SolutionTest {

    public Solution solution = new Solution();

    @Test
    public void testSinPositive(){
        solution.recursion("sin(60)", 0);
        Assert.assertEquals(solution.test, "0.87");
    }

    @Test
    public void testSinNegative(){
        solution.recursion("sin(-60)", 0);
        Assert.assertEquals(solution.test, "-0.87");
    }

    @Test
    public void testCosPositive(){
        solution.recursion("cos(60)", 0);
        Assert.assertEquals(solution.test, "0.5");
    }

    @Test
    public void testCosNegative(){
        solution.recursion("cos(-60)", 0);
        Assert.assertEquals(solution.test, "0.99");
    }
}
