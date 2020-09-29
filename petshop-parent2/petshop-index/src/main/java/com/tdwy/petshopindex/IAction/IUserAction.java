package com.tdwy.petshopindex.IAction;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tdwy.petshop.bean.Result;
import com.tdwy.petshop.bean.User;

@FeignClient("user")
public interface IUserAction {

	/**
	 * Feigin 要求对象参数标注 @RequestBody 注解 
	 */
	@PostMapping("user/login")
	Result login(@RequestBody User user);
	
	@PostMapping("user/register")
	Result register(@RequestBody User user);
}
