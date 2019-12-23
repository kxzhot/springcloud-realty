package com.fh.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@TableName("t_house")
public class HouseInfo extends Page{
    //房屋id
    private Integer  id;
    //类型id
    private Integer  typeid;
    @TableField(exist = false)
    private String typename;
    //价格
    private BigDecimal houseprice;
    //配置id
    private Integer  deployid;
    //配置详情
    @TableField(exist = false)
    private String deplovname;
    //是否下架（1：上   2：下）
    private Integer  soldout;
    //售卖人员id
    private Integer  sellid;
    @TableField(exist = false)
    private  String  sellname;
    //省id
    private Integer  provinceid;
    @TableField(exist = false)
    private String ardessname;
    //市id
    private Integer cityid;
    //县id
    private Integer countyid;
    //详情地址
    private  String  detailsaddress;
    //是否需要审核
    private Integer auditstates;
    //审核状态
    private Integer shenhestates;
    //图片路径集合
    private String  filepath;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date  createtime;
    //售卖时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date   celltime;

}
