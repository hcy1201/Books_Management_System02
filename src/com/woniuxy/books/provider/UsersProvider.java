package com.woniuxy.books.provider;

import org.apache.ibatis.jdbc.SQL;

import com.woniuxy.books.pojo.Users;

public class UsersProvider {
	/**
	 * 登录
	 * select u_id,u_name,u_pwd from users where u_name = #{u_name}
	 * @param users
	 * @return
	 */
	public String loginCheckUsers(Users users) {
		SQL sql=new SQL();
		sql.SELECT("*").FROM("users").WHERE("u_name='"+users.getU_name()+"'");
		return sql.toString();
		
	}
	/**
	 * insert into users(u_name,u_pwd) values(#{u_name},#{u_pwd})
	 * 注册
	 * @param users
	 * @return
	 */
	public String insertUser(Users users) {
		SQL sql=new SQL();
		sql.INSERT_INTO("users").VALUES("u_name,u_pwd", "'"+users.getU_name()+"','"+users.getU_pwd()+"'");
		System.out.println(sql.toString());
		return sql.toString();
		
	}

}
