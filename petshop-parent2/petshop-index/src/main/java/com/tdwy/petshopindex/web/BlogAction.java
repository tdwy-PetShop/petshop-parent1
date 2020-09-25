package com.tdwy.petshopindex.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BlogAction {

    @GetMapping("blog.html")
    public ModelAndView blog(ModelAndView mav){
        mav.setViewName("blog");
        return mav;
    }
}
