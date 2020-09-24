package com.tdwy.petshopindex.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AboutUsAction {

    @GetMapping("about-us.html")
    public ModelAndView aboutus(ModelAndView mav){
        mav.setViewName("about-us");
        return mav;
    }
}
