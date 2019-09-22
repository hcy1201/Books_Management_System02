package com.woniuxy.books.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory=null;
	static {
		try {
			InputStream iStream=Resources.getResourceAsStream("mybatis-config.xml");
			factory=new SqlSessionFactoryBuilder().build(iStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//创建工具，用来将SqlSession绑定到当前线程上
	private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<SqlSession>();
	
	//到线程上获取SqlSession
	public static SqlSession getSqlSession() {
		//当前线程上获取
		SqlSession session=threadLocal.get();
		if(session==null) {
			session=factory.openSession();
			//将session绑定到当前线程上
			threadLocal.set(session);
		}
		return session;
	}

}
