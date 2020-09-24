package com.tdwy.petshopindex.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginRegisterAction {

    @GetMapping("login-register.html")
    public ModelAndView loginregister(ModelAndView mav){
        mav.setViewName("login-register");
        return mav;
    }
}
