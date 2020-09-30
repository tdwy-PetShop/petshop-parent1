package com.tdwy.petshopuser.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tdwy.petshop.bean.Result;
import com.tdwy.petshop.bean.User;
import com.tdwy.petshop.bean.UserExample;
import com.tdwy.petshop.dao.UserMapper;

@RestController
public class UserAction {
	
	@Resource
	private UserMapper userMapper;
	
	@PostMapping("login")
	public Result<User> login(@RequestBody User user) {
		UserExample userExample=new UserExample();
		userExample.createCriteria().andNameEqualTo(user.getName()).andPwdEqualTo(user.getPwd());
		
		List<User> users =userMapper.selectByExample(userExample);
		if (users.isEmpty()) {
			return new Result<User>(0, "用户登录失败!");
		}else {
			return new Result<User>(1, "用户登录成功!",users.get(0));
		}
	}

	@PostMapping("register")
	public Result<User> register(@RequestBody User user) {
		// 带 Selective 的insert 是动态生成 字段, 非 null 字段才会参与 insert
		// insert into 表名 values ( 所有的字段值 )
		UserExample userExample=new UserExample();
		userExample.createCriteria().andNameEqualTo(user.getName());
		List<User> users =userMapper.selectByExample(userExample);
		if (users.isEmpty()) {
			userMapper.insertSelective(user);
			return new Result<User>(1, "注册成功!", user);
		}else {
			return new Result<User>(0, "注册失败!");
		}
	}
	
	
	@PostMapping("delete")
	public Result<User> delete(@RequestBody User user) {
		UserExample userExample=new UserExample();
		userMapper.deleteByExample(userExample);
		return new Result<User>(1, "删除成功!", user);
	}
	
	@PostMapping("update")
	public Result<User> update(@RequestBody User user) {
		UserExample userExample=new UserExample();
		userExample.createCriteria().andNameEqualTo(user.getName()).andPwdEqualTo(user.getPwd()).andSexEqualTo(user.getSex()).andPhoneEqualTo(user.getPhone()).andEmailEqualTo(user.getEmail());
		userMapper.updateByExample(user, userExample);
		return new Result<User>(1, "修改成功!", user);
	}
}
