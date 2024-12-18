package com.qiu.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@TableName("t_smalltype")
@Data
public class SmallType {
    private Integer id; //编号
    private String name; //名称
    private String remark; //描述
    private Integer bigTypeId; //商品大类编号

    //查询时忽略该字段
    @TableField(select = false)
    private BigType bigType;//大类
    @TableField(select = false)
    private List<Product> productList;//大类商品
}
