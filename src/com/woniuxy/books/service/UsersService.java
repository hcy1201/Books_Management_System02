package com.woniuxy.books.service;

import com.woniuxy.books.pojo.Users;

public interface UsersService {

	/**
	 * 用户登录判断
	 * @param users
	 * @return
	 */
	public Users loginCheckUsers(Users users);
	
	/**
	 * 注册用户
	 * @param users
	 * @return
	 */
	public boolean insertUser(Users users);
}
