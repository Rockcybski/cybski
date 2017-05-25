package com.rock.cybski.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.rock.cybski.entity.User;

@RestController
@RequestMapping(value="/test")
public class SpringParamBindingController {
	
	/*
	 * 有 @ModelAttribute 标记的方法, 会在@RequestMapping目标方法执行之前被 SpringMVC 调用
	 */
	@ModelAttribute
	public void getUser(Map<String, Object> map){
		//模拟从数据库获取user
		User user = User.getNewUser(1, "Rock");
		map.put("user", user);
	}
	
	/*
	 * Spring MVC 执行过程：
	 * 1，执行getUser方法，将user存入map
	 * 2，从map取出user，并将请求中对应属性赋给user
	 * 3，将user传入updateUser方法参数
	 */
	@RequestMapping("/user")//？introduction=updated
	@ResponseBody
	@JsonRawValue
	public Boolean updateUser(User user){
		System.out.println(user); //User [id=1, name=Rock, introduction=New User]
		return true;
	}
	
	@RequestMapping("/listUser")
//	@ResponseBody
	public List<User> listUser(){
		List<User> result = new ArrayList<>();
		User user1 = User.getNewUser(2, "Micky");
		User user2 = User.getNewUser(3, "Cindy");
		result.add(user1);
		result.add(user2);
		return result;
	}
	
	@RequestMapping("/test")
	public void test(){
		System.out.println("test");
	}
}
