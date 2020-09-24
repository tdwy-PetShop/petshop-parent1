package com.tdwy.petshopindex.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WishListAction {

    @GetMapping("wishlist.html")
    public ModelAndView wishlist(ModelAndView mav){
        mav.setViewName("wishlist");
        return mav;
    }
}
