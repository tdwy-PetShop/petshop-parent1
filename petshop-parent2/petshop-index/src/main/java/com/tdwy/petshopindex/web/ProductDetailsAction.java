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
import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductDetailsAction {
    @Resource
    IProductAction iProductAction;

    @GetMapping("product-details.html")
    public ModelAndView productdetails(@RequestParam(value = "id",required = false,defaultValue = "1") int id, ModelAndView mav) {
        Result<List<Category>> cres=iProductAction.showCategory();
        if (cres.getCode()==1){
            mav.addObject("categorylist",cres.getData());
        }
        mav.addObject("productDetails", iProductAction.productDetails(id));
        mav.setViewName("product-details");
        return mav;
    }


}
