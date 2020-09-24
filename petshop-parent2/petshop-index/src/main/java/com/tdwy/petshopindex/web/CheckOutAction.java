package com.tdwy.petshopindex.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CheckOutAction {

    @GetMapping("checkout.html")
    public ModelAndView checkout(ModelAndView mav){
        mav.setViewName("checkout");
        return mav;
    }
}
