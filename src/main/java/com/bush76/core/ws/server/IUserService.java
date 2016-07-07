package com.bush76.core.ws.server;

import java.util.Map;

import com.bush76.core.entity.User;

public interface IUserService {

	User getUser(int id);
	
	String addUser(Map<String,Object> map);

}
