package com.qiu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@TableName("t_bigtype")
@Data
public class BigType {
    private Integer id;//id
    private String name;//名字
    private String remark;//描述
    private String image="default.jpg";//图片
    @TableField(select = false)
    private List<SmallType> smallTypes;//商品小类

}
