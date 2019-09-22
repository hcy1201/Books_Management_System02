package com.woniuxy.books.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.woniuxy.books.pojo.Users;
import com.woniuxy.books.service.UsersService;

import lombok.Data;

@Data
@Controller
public class UserAction {
	@Autowired
	private UsersService usersService;
	private String reReslut;
	private Users clientUser;
	
	
	public String loginCheck(){
		System.out.println(clientUser);
		String reslut=reReslut="fail";
		
		if(clientUser==null) {
			return reslut;
		}
		Users user = usersService.loginCheckUsers(clientUser);
		if(user!=null) {
			if(user.getU_pwd().equals(clientUser.getU_pwd())) {
				
				reslut=reReslut="success";
			}
		}
		
		return reslut;
	}
	

}
