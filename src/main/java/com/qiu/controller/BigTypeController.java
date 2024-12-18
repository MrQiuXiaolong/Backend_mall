package com.qiu.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qiu.entity.BigType;
import com.qiu.entity.Product;
import com.qiu.entity.Result;
import com.qiu.entity.SmallType;
import com.qiu.service.BigTypeService;
import com.qiu.service.ProductService;
import com.qiu.service.SmallTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bigType")
public class BigTypeController {
    @Autowired
    private BigTypeService bigTypeService;
    @Autowired
    private SmallTypeService smallTypeService;
    @Autowired
    private ProductService productService;

    /**
     * 主页->大分类
     * @return
     */
    @GetMapping("/findAll")
    public Result findAll(){
        List<BigType> bigTypeList = bigTypeService.list();
        Map<String,Object> map = new HashMap<>();
        map.put("message",bigTypeList);
        return Result.ok(map);

    }

    /**
     * 分类->分类
     * BigType
     *        ->
     *           SmallType
     *                    ->
     *                      Product
     *1.先查找大分类的表,获取到数据
     *2.通过获取的数据查询小分类的表 查询的结果存储到 BigType实体类中的smallTypes
     *3.在查询详细数据表 查询到的结果存储到实体类中的SmallType的setProductList中
     *
     * findCategories (GET)
     * ├── 获取所有大分类 bigTypeList (bigTypeService.list())
     * │   ├── 遍历大分类 bigType
     * │   │   ├── 根据 bigTypeId 查询对应小分类 smallTypeList (smallTypeService.list())
     * │   │   │   ├── 遍历小分类 smallType
     * │   │   │   │   ├── 根据 typeId 查询对应产品 productList (productService.list())
     * │   │   │   │   └── 设置产品到小分类 smallType.setProductList(productList)
     * │   │   └── 设置小分类到大分类 bigType.setSmallTypes(smallTypeList)
     * ├── 封装数据到 map ("message" -> bigTypeList)
     * └── 返回 Result.ok(map)
     * @return Result.ok(map)
     */
    @GetMapping("/findCategories")
    public Result findCategories(){
        List<BigType> bigTypeList = bigTypeService.list();
        for (BigType bigType : bigTypeList) {
            //通过条件eq查询到 bigTypeId和bigType编号相同的值
            List<SmallType> smallTypeList = smallTypeService.list(new QueryWrapper<SmallType>().eq("bigTypeId", bigType.getId()));
            bigType.setSmallTypes(smallTypeList);
            for (SmallType smallType :smallTypeList){
                List<Product> productList = productService.list(new QueryWrapper<Product>().eq("typeId", smallType.getBigTypeId()));
                smallType.setProductList(productList);
            }

        }
        Map<String,Object> map = new HashMap<>();
        map.put("message",bigTypeList);
        return Result.ok(map);
    }
}
