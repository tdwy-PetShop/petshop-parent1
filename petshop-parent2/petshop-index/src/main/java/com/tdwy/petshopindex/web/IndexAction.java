package com.tdwy.petshopindex.web;

import com.tdwy.petshopindex.IAction.IProductAction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@RestController
public class IndexAction {
    @Resource
    IProductAction iProductAction;
    @GetMapping({"/","index.html"})
    public ModelAndView index(ModelAndView mav){
        mav.addObject("recentProducts",iProductAction.recentProducts());
        mav.setViewName("index");
        return mav;
    }
}
