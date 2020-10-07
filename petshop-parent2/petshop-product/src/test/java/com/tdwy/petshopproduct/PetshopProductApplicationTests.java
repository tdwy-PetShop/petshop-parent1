package com.tdwy.petshopproduct;

import com.tdwy.petshop.bean.Category;
import com.tdwy.petshop.bean.Product;
import com.tdwy.petshop.bean.Result;
import com.tdwy.petshopproduct.biz.CategoryBiz;
import com.tdwy.petshopproduct.biz.OrdersBiz;
import com.tdwy.petshopproduct.biz.ProductBiz;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootTest
class PetshopProductApplicationTests {
    @Resource
    OrdersBiz cb;
    @Test
    void contextLoads() {
        cb.changeState(0,"20201006190634");
    }

}
