package com.tdwy.petshopindex.web;

import com.tdwy.petshop.bean.Cart;
import com.tdwy.petshop.bean.Result;
import com.tdwy.petshop.bean.User;
import com.tdwy.petshopindex.IAction.IProductAction;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
public class CartAction {
    @Resource
    IProductAction iProductAction;


    @GetMapping("cart.html")
    public ModelAndView cart(HttpSession session, ModelAndView mav) {
        User loginedUser=(User)session.getAttribute("loginedUser");
        if (loginedUser != null) {
            mav.addObject("cartList", iProductAction.showCart(loginedUser).getData());
            mav.setViewName("cart");
        } else {
            mav.setViewName("redirect:login-register.html");
        }
        return mav;
    }

    @PostMapping("addCart.do")
    public ModelAndView addCart(@RequestParam int pid, @RequestParam int count, HttpSession session, ModelAndView mav) {
        User loginedUser=(User)session.getAttribute("loginedUser");
        if (loginedUser!=null){
            Result res = iProductAction.addCart(pid, count, loginedUser);
            if (res.getCode() == 1) {
                mav.setViewName("redirect:cart.html");
            } else {
                if ("系统错误".equals(res.getMsg())) {
                    mav.setViewName("redirect:product-details?pid=" + pid);
                }
            }
            mav.addObject("Result", res);
        }else {
            mav.setViewName("redirect:/login-register.html");
        }
        return mav;
    }
}
