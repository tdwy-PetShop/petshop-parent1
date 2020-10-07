package com.tdwy.petshopindex.web;

import com.tdwy.petshop.bean.Category;
import com.tdwy.petshop.bean.Orders;
import com.tdwy.petshop.bean.Result;
import com.tdwy.petshop.bean.User;
import com.tdwy.petshopindex.IAction.IProductAction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class OrdersAction {
    @Resource
    IProductAction iProductAction;


    @GetMapping("orders.html")
    public ModelAndView cart(HttpSession session, ModelAndView mav) {

        User loginedUser=(User)session.getAttribute("loginedUser");
        if (loginedUser != null) {
            Result<List<Orders>> cres=iProductAction.showOrders(loginedUser);
            if (cres.getCode()==1){
                mav.addObject("ordersList",cres.getData());
            }
            mav.setViewName("orders");
        } else {
            mav.setViewName("redirect:login-register.html");
        }
        return mav;
    }



}
