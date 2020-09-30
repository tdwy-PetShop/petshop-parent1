package com.tdwy.petshopindex.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.tdwy.petshop.bean.Result;
import com.tdwy.petshop.bean.User;
import com.tdwy.petshop.bean.UserExample;
import com.tdwy.petshop.dao.UserMapper;
import com.tdwy.petshopindex.IAction.IUserAction;



@RestController
@SessionAttributes ("loginedUser")
public class LoginRegisterAction {

	@Resource
	private IUserAction uaction;
	
	
    @GetMapping("login-register.html")
    public ModelAndView loginregister(ModelAndView mav){
        mav.setViewName("login-register");
        return mav;
    }
    
    /**
	 *  @RestController 控制器存会话, 必须获取HttpSession对象
	 *  @Controller 控制器存会话, 使用 @SessionAttributes 
	 */
	@PostMapping("login")
	public ModelAndView login( @Valid User user, Errors errors, ModelAndView m,HttpSession session) {

		// 验证用户输入的数据是否正确
		if (errors.hasFieldErrors("name") || errors.hasFieldErrors("pwd")) {
			m.addObject("user", user);
			m.addObject("errors", errors.getFieldErrors());
			m.setViewName("login-register");
			return m;
		}

		// 发起远程服务调用， 传递2个参数（用户名，密码）
		Result<User> res = uaction.login(user);

		// 根据返回的结果，如果正确跳转首页
		if(res.getCode() == 1) {
			//问题：从Result里面获取用户
			m.addObject("loginedUser", res.getData());
			session.setAttribute("loginedUser", user);
			m.setViewName("index");
			return m;
		} else {
			// 自定义一个错误
			errors.rejectValue("name", "NameOrPwdError","用户名或密码错误");
			m.addObject("errors", errors.getFieldErrors());
			// 如果错误，跳转回登录页
			m.setViewName("login-register");
			return m;
		}

	}
	
	@PostMapping("register")
	public ModelAndView register(@Valid User user, Errors errors, String repwd, ModelAndView m) {

		if(repwd == null || repwd.trim().isEmpty()) {
			errors.rejectValue("pwd", "repwdError", "请输入确认密码");
		}else if(repwd.equals(user.getPwd()) == false) {
			errors.rejectValue("pwd", "repwdError", "两次输入的密码不一致");
		}
		if (errors.hasErrors()) {
			// 将用户填写的数据传回页面
			m.addObject("user", user);
			m.addObject("errors", errors.getFieldErrors());
			m.setViewName("login-register");
			return m;
		}

		// 发起远程服务调用， 传递2个参数（用户名，密码）
		Result<User> res = uaction.register(user);

		// 根据返回的结果，如果正确跳转首页
		if (res.getCode() == 1) {
			/**
			 * Feign 对于 Result.data 的类型, 如果data是Object类型, 会将其转为 LinkedHashMap
			 * 		 使用泛型那么 Feign 就是正确转换类型
			 */
			m.addObject("loginedUser", res.getData());
			m.setViewName("index");
			return m;
		} else {
			errors.rejectValue("name", "NameOrPwdError","该用户名已被注册!");
			m.addObject("errors", errors.getFieldErrors());
			// 如果错误，跳转回注册页
			m.setViewName("login-register");
			return m;
		}
	}
}
