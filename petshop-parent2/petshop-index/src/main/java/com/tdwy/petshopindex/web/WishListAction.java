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
public class WishListAction {
    @Resource
    IProductAction iProductAction;
    @GetMapping("wishlist.html")
    public ModelAndView wishlist(ModelAndView mav){
        Result<List<Category>> cres=iProductAction.showCategory();
        if (cres.getCode()==1){
            mav.addObject("categorylist",cres.getData());
        }
        mav.setViewName("wishlist");
        return mav;
    }
}
