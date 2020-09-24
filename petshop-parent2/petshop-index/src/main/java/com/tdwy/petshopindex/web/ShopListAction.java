package com.tdwy.petshopindex.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ShopListAction {

    @GetMapping("shop-list.html")
    public ModelAndView shoplist(ModelAndView mav){
        mav.setViewName("shop-list");
        return mav;
    }
}
