package com.bush76.core.ws.server.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.bush76.core.entity.User;
import com.bush76.core.ws.server.IHelloService;

@WebService
public class HelloServiceImpl implements IHelloService {

	@WebMethod(operationName="say")
	@WebResult(name="sayResult")
	public String say(@WebParam(name="name")String name) {
		System.out.println(name);
		return "{\"name\":\"zhangsan\"}";
	}

	@Override
	public List<User> list() {
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setId("" + i);
			user.setName("user_" + i);
			user.setPassword("password_" + i);
			users.add(user);
		}
		return users;
	}

	@Override
	public Map<String, User> getUserMap() {
		Map<String, User> userMap = new LinkedHashMap<String, User>();
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setId("" + i);
			user.setName("user_" + i);
			user.setPassword("password_" + i);
			userMap.put(user.getId(), user);
		}
		return userMap;
	}

	@Override
	public Map<String, Object> getMapObject() {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name", "zhangsan");
		return map;
	}

	@Override
	public String saveUser(User user) {
		System.out.println(user.getId() + " - " + user.getName() + " - " + user.getPassword());
		return "{\"result\":\"success\"}";
	}

	@Override
	public Map<String, Object> getUser() {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name", "zhangsan");
		return map;
	}

}