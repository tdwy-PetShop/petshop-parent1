package com.tdwy.petshopindex.web;

import com.tdwy.petshop.bean.Product;
import com.tdwy.petshopindex.IAction.IProductAction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class ProductDetailsAction {
    @Resource
    IProductAction iProductAction;

    @GetMapping("product-details.html")
    public ModelAndView productdetails(int id, ModelAndView mav) {
        System.out.println(id);
        mav.addObject("productDetails", iProductAction.productDetails(id));
        mav.setViewName("product-details");
        return mav;
    }
}
