package com.tjetc.common;
//commom 指的是公共代码
import javafx.application.Application;
import javafx.stage.Stage;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

//final 用在类上表示 类不能被继承
public final class SqlSessionUtils {
    //定义静态成员变量（私有的）
    private static SqlSessionFactoryBuilder builder;
    private static SqlSessionFactory sqlSessionFactory;

    //定义私有的构造方法，目的 不让使用者去new对象
    private SqlSessionUtils(){

    }

    //静态代码块，执行时机：类被使用的时候而且只执行一次
    static {
        //创建SqlSessionFactoryBuilder对象
        builder = new SqlSessionFactoryBuilder();
        //创建SqlSessionFactory对象
        try {
            sqlSessionFactory =builder.build(Resources.getResourceAsReader("mybatis.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //静态方法（使用过程不需要创建对象，直接使用类.静态方法），获取SqlSession对象
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}

