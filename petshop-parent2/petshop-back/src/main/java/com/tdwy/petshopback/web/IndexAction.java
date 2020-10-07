package com.tdwy.petshopback.web;

import com.tdwy.petshopback.IAction.IProductAction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@RestController
@RequestMapping("back")
public class IndexAction {

    @Resource
    IProductAction iProductAction;
    @GetMapping("index.html")
    public ModelAndView index(ModelAndView mav){
        mav.setViewName("index");
        return mav;
    }
    @GetMapping("type.html")
    public ModelAndView type(ModelAndView mav){
        mav.setViewName("type");
        return mav;
    }
    @GetMapping("product.html")
    public ModelAndView product(ModelAndView mav){
        mav.addObject("products",iProductAction.recentProducts());
        mav.setViewName("product");
        return mav;
    }
    @GetMapping("advert.html")
    public ModelAndView advert(ModelAndView mav){
        mav.setViewName("advert");
        return mav;
    }
    @GetMapping("advert-add.html")
    public ModelAndView advertadd(ModelAndView mav){
        mav.setViewName("advert-add");
        return mav;
    }
    @GetMapping("login.html")
    public ModelAndView login(ModelAndView mav){
        mav.setViewName("login");
        return mav;
    }
    @GetMapping("type-add.html")
    public ModelAndView typeadd(ModelAndView mav){
        mav.setViewName("type-add");
        return mav;
    }
    @GetMapping("unicode.html")
    public ModelAndView unicode(ModelAndView mav){
        mav.setViewName("unicode");
        return mav;
    }
    @GetMapping("user.html")
    public ModelAndView user(ModelAndView mav){
        mav.setViewName("user");
        return mav;
    }
    @GetMapping("welcome.html")
    public ModelAndView welcome(ModelAndView mav){
        mav.setViewName("welcome");
        return mav;
    }
}
