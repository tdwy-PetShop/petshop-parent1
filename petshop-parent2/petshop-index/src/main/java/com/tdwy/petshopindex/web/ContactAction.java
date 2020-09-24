package com.tdwy.petshopindex.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ContactAction {

    @GetMapping("contact.html")
    public ModelAndView contact(ModelAndView mav){
        mav.setViewName("contact");
        return mav;
    }
}
