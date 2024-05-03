package com.hbsfdxwlxy.junit.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * 测试类
 * 命名规范：测试的对象类+Test
 */
public class MathServiceTest {
    // 测试sum方法
    MathService mathService = new MathService();
    // 测试的方法名也是有规范的，test+方法名，然后用注解进行标注
    @Test
    public void testSum(){
        // 实际值，就是你的service方法中跑出来的值，actual
        int actual = mathService.sum(1, 2);
        // 期望值，就是你认为的值，expected
        int expected = 3;
        // 加入断言来进行验证
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testSub(){
        int actual = mathService.sub(1 , 2);
        int expected = -1;
        Assert.assertEquals(expected,actual);
    }
}
