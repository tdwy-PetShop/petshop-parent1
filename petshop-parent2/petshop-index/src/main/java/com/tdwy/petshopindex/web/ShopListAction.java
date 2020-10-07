package com.tdwy.petshopindex.web;

import com.tdwy.petshop.bean.Category;
import com.tdwy.petshop.bean.Result;
import com.tdwy.petshopindex.IAction.IProductAction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ShopListAction {
    @Resource
    IProductAction iProductAction;
    @GetMapping("shop-list.html")
    public ModelAndView shoplist(ModelAndView mav){
        Result<List<Category>> res=iProductAction.showCategory();
        if (res.getCode()==1){
            mav.addObject("categorylist",res.getData());
        }
        mav.setViewName("shop-list");
        return mav;
    }
}
