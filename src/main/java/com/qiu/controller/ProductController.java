package com.qiu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qiu.entity.Product;
import com.qiu.entity.ProductSwiperImage;
import com.qiu.entity.Result;
import com.qiu.service.ProductService;
import com.qiu.service.ProductSwiperImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品接口控制层
 */

@RestController
@RequestMapping("/product")
public class ProductController{
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductSwiperImageService productSwiperImageService;

    /**
     * 主页->轮播图
     * @return
     */
    @GetMapping("/findSwiper")
    public Result findSwiper(){
        //eq("isSwiper", true) 查询结果为真的条件  orderByAsc("swiperSort")按照排序方式来
        List<Product> swiperProductList = productService.list(new QueryWrapper<Product>().eq("isSwiper", true).orderByAsc("swiperSort"));
        Map<String,Object> map=new HashMap<>();
        map.put("message",swiperProductList);
        return Result.ok(map);
    }

    /**
     * 主页->商品热卖
     * @return
     */
    @GetMapping("/findIsHost")
    public Result findIsHost(){
        Page<Product> page=new Page<>(1,8);
        //分页数据 页码 总数 分页对象
        Page<Product> IsHostList = productService.page(page, new QueryWrapper<Product>().eq("isHost", true).orderByAsc("hotDateTime"));
        //返回具体的查询结果 方便与实体类映射
        List<Product> productsList = IsHostList.getRecords();
        Map<String,Object> map=new HashMap<>();
        map.put("message",productsList);
        return Result.ok(map);
    }
    @GetMapping("/detail")
    public Result detail(Integer id){
        Product product = productService.getById(id);
        List<ProductSwiperImage> productSwiperImageList = productSwiperImageService.list(new QueryWrapper<ProductSwiperImage>().eq("productId", product.getId()).orderByAsc("sort"));
        product.setProductSwiperImageList(productSwiperImageList);
        Map<String,Object> map=new HashMap<>();
        map.put("message",product);
        return Result.ok(map);
    }

    @GetMapping("/search")
    public Result search(String q){
        List<Product> productList = productService.list(new QueryWrapper<Product>().like("name", q));

        Map<String,Object> map=new HashMap<>();
        map.put("productList",productList);
        return Result.ok(map);

    }
}
