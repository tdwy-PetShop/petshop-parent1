package com.tdwy.petshopindex.web;

import com.tdwy.petshop.bean.Category;
import com.tdwy.petshop.bean.Product;
import com.tdwy.petshop.bean.Result;
import com.tdwy.petshopindex.IAction.IProductAction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ShopPageAction {
    @Resource
    IProductAction iProductAction;

    @GetMapping("shop-page.html")
    public ModelAndView shoppage(@RequestParam(value = "id",required = false,defaultValue = "1") int id ,ModelAndView mav){
        Result<List<Category>> cres=iProductAction.showCategory();
        if (cres.getCode()==1){
            mav.addObject("categorylist",cres.getData());
        }
        Result<List<Category>> res=iProductAction.showCategory();
        if (res.getCode()==1){
            mav.addObject("category",res.getData());
        }
        Result<List<Product>> pres=iProductAction.showProductCate(id);
        if (pres.getCode()==1){
            mav.addObject("products",pres.getData());
        }
        mav.setViewName("shop-page");
        return mav;
    }

    @PostMapping("classquery.do")
    public ModelAndView showProductCate(@RequestParam(value = "id",required = false,defaultValue = "1") int id , ModelAndView mav){
        Result<List<Product>> res=iProductAction.showProductCate(id);
        if (res.getCode()==1){
            mav.addObject("products",res.getData());
        }
        mav.setViewName("redirect:shop-page.html");
        return mav;
    }

}
