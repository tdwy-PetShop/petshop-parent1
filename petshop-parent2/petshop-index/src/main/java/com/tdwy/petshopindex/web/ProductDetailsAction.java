package com.tdwy.petshopindex.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ProductDetailsAction {

    @GetMapping("product-details.html")
    public ModelAndView productdetails(ModelAndView mav){
        mav.setViewName("product-details");
        return mav;
    }
}
