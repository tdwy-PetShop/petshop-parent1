package com.tdwy.petshopindex.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyAccountAction {

    @GetMapping("my-account.html")
    public ModelAndView myaccount(ModelAndView mav){
        mav.setViewName("my-account");
        return mav;
    }
}
