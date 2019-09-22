package com.woniuxy.books.service.imp;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.books.mapper.UsersMapper;
import com.woniuxy.books.pojo.Users;
import com.woniuxy.books.service.UsersService;

import lombok.Data;

@Data
@Service
public class UsersServiceImp implements UsersService{
	@Autowired
	UsersMapper usersMapper ;
	
	/**
	 * 用户登录判断
	 * @param users
	 * @return
	 */
	public Users loginCheckUsers(Users users) {
		Users user = usersMapper.loginCheckUsers(users);
		return user;
	}
	
	/**
	 * 注册用户
	 * @param users
	 * @return
	 */
	public boolean insertUser(Users users) {
		boolean flag=false;
		int res=usersMapper.insertUser(users);
		if(res>0) {
			flag=true;
		}
		return flag;
	}
	

}
