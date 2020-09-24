package com.tdwy.petshopindex.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ShopPageAction {

    @GetMapping("shop-page.html")
    public ModelAndView shoppage(ModelAndView mav){
        mav.setViewName("shop-page");
        return mav;
    }
}
