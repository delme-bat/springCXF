package com.bush76.core.ws.server.impl;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.model.wadl.Description;
import org.apache.cxf.jaxrs.model.wadl.DocTarget;

import com.bush76.core.entity.User;
import com.bush76.core.ws.server.IUserService;

public class UserServiceImpl implements IUserService {

	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public User getUser(@PathParam("id") int id) {
		User user = new User();
		user.setId("1");
		user.setName("admin");
		user.setPassword("123");
		return user;
	}
	
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@Description(value = "添加用户", target = DocTarget.METHOD)
	public String addUser(Map<String,Object> map) {
		System.out.println(map);
		return "返回中文测试";
	}
}
