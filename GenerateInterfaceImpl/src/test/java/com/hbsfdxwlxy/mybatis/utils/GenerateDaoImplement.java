package com.hbsfdxwlxy.mybatis.utils;

import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * Object o = GenerateDaoByJavassist(SqlSession sqlSession,Class Interface)
 * 工具类：用于实现通过interface接口去自动实现其所涵盖的抽象方法
 */
public class GenerateDaoImplement {
    private GenerateDaoImplement(){}
    public static Object GenerateDaoInterface(SqlSession sqlSession,Class interfaceDao){
        // 获取类池
        ClassPool pool = ClassPool.getDefault();
        // 创建接口实现类
        CtClass ctClass = pool.makeClass(interfaceDao.getName() + "Impl");
        // 创建接口类
        CtClass ctInterface = pool.makeInterface(interfaceDao.getName());
        // 将接口类与实现类进行绑定
        ctClass.addInterface(ctInterface);
        // 实现接口
        // 创建抽象方法
        Object object = null;
        /*
        public Account selectActByActno(String actno){
            SqlSession sqlSession = SqlSessionUtils.openSession();
            return (Account) sqlSession.selectOne("account.selectActByActno", actno);
        }
        */
        try {
            Method[] methods = interfaceDao.getDeclaredMethods();
            Arrays.stream(methods).forEach(method -> {
                try {
                    StringBuilder methodCode = new StringBuilder();
                    // 开始拼接字符串
                    methodCode.append("public ");
                    methodCode.append(method.getReturnType().getName());
                    methodCode.append(" ");
                    methodCode.append(method.getName());
                    methodCode.append("(");

                    Parameter[] parameters = method.getParameters();
                    for (int i = 0; i < parameters.length; i++) {
                        methodCode.append(parameters[i].getType().getName());
                        methodCode.append(" ");
                        methodCode.append("arg" + i);
                        if (i !=parameters.length - 1){
                            methodCode.append(",");
                        }
                    }
                    methodCode.append("){");
                    methodCode.append("org.apache.ibatis.session.SqlSession sqlSession = com.hbsfdxwlxy.mybatis.utils.SqlSessionUtils.openSession();");
                    // 判断是什么类型的sql语句
                    String sqlId = interfaceDao.getName() + "." + method.getName();
                    // 通过sqlId去获取执行什么类型的sql语句
                    SqlCommandType sqlCommandType = sqlSession.getConfiguration().getMappedStatement(sqlId).getSqlCommandType();
                    if (sqlCommandType == SqlCommandType.SELECT) {
                        // return (Account) sqlSession.selectOne("account.selectActByActno", actno);
                        methodCode.append("return (" + method.getReturnType().getName() + ") sqlSession.selectOne(\"" + sqlId + "\", arg0);");
                    }  else if (sqlCommandType == SqlCommandType.UPDATE) {
                        // return sqlSession.update("account.updateActByActno", act);
                        methodCode.append("return sqlSession.update(\"" + sqlId + "\", arg0);");
                    }
                    methodCode.append("}");
                    System.out.println(methodCode);

                    CtMethod ctMethod = CtMethod.make(methodCode.toString(), ctClass);
                    ctClass.addMethod(ctMethod);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            // 类加载
            Class<?> clazz = ctClass.toClass();
            object = clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }
}
