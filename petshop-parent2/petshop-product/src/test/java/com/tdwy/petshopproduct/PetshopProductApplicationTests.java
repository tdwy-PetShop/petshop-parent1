package com.tdwy.petshopproduct;

import com.tdwy.petshop.bean.Product;
import com.tdwy.petshopproduct.biz.ProductBiz;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class PetshopProductApplicationTests {
    @Resource
    ProductBiz pb;
    @Test
    void contextLoads() {
        List<Product> list= pb.recentProducts();
        for (Product p : list){
            System.out.println(p);
        }
    }

}
