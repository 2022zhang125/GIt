package com.hbsfdxwlxy.javassist.test;

import com.hbsfdxwlxy.mybatis.bank.dao.AccountDao;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.junit.Test;

import java.lang.reflect.Method;

public class JavassistTest {
    @Test
    public void testGenerateInterfaceClass() throws Exception{
        // 实现接口类的方法
        // 第一步：创建类池
        ClassPool pool = ClassPool.getDefault();
        // 第二步：创建实现类，作为容器
        CtClass accountDaoImpl = pool.makeClass("com.hbsfdxwlxy.mybatis.bank.dao.impl.AccountDaoImpl");
        // 第三步：创建一个接口类
        CtClass accountDao = pool.makeInterface("com.hbsfdxwlxy.mybatis.bank.dao.AccountDao");
        // 第四步：将接口类接到实现类中（Class implements AccountDao）
        accountDaoImpl.addInterface(accountDao);
        // 第五步：实现方法
        String str = "public void Hello(){System.out.println(\"Hello World\");}";
        CtMethod ctMethod = CtMethod.make(str, accountDaoImpl);
        // 第六步：将方法加入到实现类中
        accountDaoImpl.addMethod(ctMethod);
        // 第七步：类加载
        Class<?> accountDaoImplClazz = accountDaoImpl.toClass();
        // 第八步：创建对象
        AccountDao dao = (AccountDao) accountDaoImplClazz.getDeclaredConstructor().newInstance();
        // 第九步：调用方法
        dao.Hello();
    }

    @Test
    public void testGenerateFirstClass() throws Exception{
        // 创建类池
        ClassPool pool = ClassPool.getDefault();
        // 检查类是否已存在
        if (pool.getOrNull("com.hbsfdxwlxy.mybatis.bank.dao.impl.AccountDaoImpl") != null) {
            return;  // 类已存在，直接返回
        }
        // 创建类.加类名
        CtClass ctClass = pool.makeClass("com.hbsfdxwlxy.mybatis.bank.dao.impl.AccountDaoImpl");
        // 创建方法
        String str = "public void Hello(){System.out.println(\"Hello World\");}";
        CtMethod ctMethod = CtMethod.make(str, ctClass);
        // 将方法加入类中
        ctClass.addMethod(ctMethod);
        // 在内存中生成Class
        Class<?> clazz = ctClass.toClass();


        // 创建对象
        Object object = clazz.newInstance();
        // 获取方法
        Method hello = clazz.getDeclaredMethod("Hello");
        // 调用方法
        hello.invoke(object);
    }
}
