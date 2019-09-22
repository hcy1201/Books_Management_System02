package com.woniuxy.books.mapper;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;

import com.woniuxy.books.pojo.Users;
import com.woniuxy.books.provider.UsersProvider;

public interface UsersMapper {
	
	/**
	 * 用户登录判断
	 * @param users
	 * @return
	 */
	@SelectProvider(type = UsersProvider.class,method = "loginCheckUsers")
	public Users loginCheckUsers(Users users);
	
	/**
	 * 注册用户
	 * @param users
	 * @return
	 */
	@InsertProvider(type = UsersProvider.class,method = "insertUser")
	public int insertUser(Users users);
	
}
