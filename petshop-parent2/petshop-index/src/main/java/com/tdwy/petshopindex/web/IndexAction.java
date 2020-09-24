package com.tdwy.petshopindex.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexAction {

    @GetMapping({"/","index.html"})
    public ModelAndView index(ModelAndView mav){
        mav.setViewName("index");
        return mav;
    }
}
