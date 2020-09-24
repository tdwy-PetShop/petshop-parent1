package com.tdwy.petshopindex.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CartAction {

    @GetMapping("cart.html")
    public ModelAndView cart(ModelAndView mav){
        mav.setViewName("cart");
        return mav;
    }
}
