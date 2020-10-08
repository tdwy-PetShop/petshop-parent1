package com.tdwy.petshopindex.web;


import com.tdwy.petshop.bean.Orders;
import com.tdwy.petshop.bean.Result;
import com.tdwy.petshopindex.IAction.IProductAction;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("back")
public class BackAction {

    @Resource
    IProductAction iProductAction;
    @GetMapping("bindex.html")
    public ModelAndView index(ModelAndView mav){
        mav.setViewName("bindex");
        return mav;
    }
    @GetMapping("btype.html")
    public ModelAndView type(ModelAndView mav){
        mav.setViewName("btype");
        return mav;
    }
    @GetMapping("bproduct.html")
    public ModelAndView product(ModelAndView mav){
        mav.addObject("products",iProductAction.recentProducts());
        mav.setViewName("bproduct");
        return mav;
    }
    @GetMapping("badvert.html")
    public ModelAndView advert(ModelAndView mav){
        Result<List<Orders>> res=iProductAction.showAllOrders();
        mav.addObject("orders",res.getData());
        mav.setViewName("badvert");
        return mav;
    }
    @GetMapping("badvert-add.html")
    public ModelAndView advertadd(ModelAndView mav){
        mav.setViewName("badvert-add");
        return mav;
    }
    @GetMapping("blogin.html")
    public ModelAndView login(ModelAndView mav){
        mav.setViewName("blogin");
        return mav;
    }
    @GetMapping("btype-add.html")
    public ModelAndView typeadd(ModelAndView mav){
        mav.setViewName("btype-add");
        return mav;
    }
    @GetMapping("bunicode.html")
    public ModelAndView unicode(ModelAndView mav){
        mav.setViewName("bunicode");
        return mav;
    }
    @GetMapping("buser.html")
    public ModelAndView user(ModelAndView mav){
        mav.setViewName("buser");
        return mav;
    }
    @GetMapping("bwelcome.html")
    public ModelAndView welcome(ModelAndView mav){
        mav.setViewName("bwelcome");
        return mav;
    }

    @PostMapping("fahuo.do")
    public ModelAndView fahuo(@RequestParam String orderid,ModelAndView mav){
        iProductAction.changeState(2,orderid);
        mav.setViewName("redirect:bindex.html");
        return mav;
    }


}
