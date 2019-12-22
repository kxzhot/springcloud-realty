package com.fh.controller;

import com.fh.commen.ServerResponse;
import com.fh.model.City;
import com.fh.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "city")
@RestController
public class ZtreeController {
    @Autowired
    private CityService cityService;

    //查询省份下拉
    @RequestMapping(value = "queryByPid")
    public ServerResponse queryByPid(Integer pid){
        List<City> li=cityService.queryByPid(pid);
        return ServerResponse.success(li);
    }
    //查询省份下拉
    @RequestMapping(value = "queryById")
    public ServerResponse queryById(Integer id){
        City li=cityService.queryById(id);
        return ServerResponse.success(li);
    }
    //页面展示省市县
    @RequestMapping(value = "queryCityData")
    public String queryCityData(Integer proId,Integer areaId,Integer ComId){
        String area=cityService.queryCityData(proId,areaId,ComId);
        return area;
    }
    //ztree页面获取城市信息
    @RequestMapping(value = "queryList")
    public ServerResponse  queryList() {
        List<City> toadd = cityService.queryList();
        return ServerResponse.success(toadd);
    }
    @RequestMapping(value = "updateCity")
    public ServerResponse updateCity(City c){
        cityService.updateCity(c);
        return ServerResponse.success();
    }
    //添加地区
    @RequestMapping(value = "addCity")
    public ServerResponse addCity(City c){
        cityService.addCity(c);
        return ServerResponse.success();
    }
    //删除
    @RequestMapping(value = "deleteNode")
    public ServerResponse deleteNode(Integer id){
        cityService.deleteNode(id);
        return ServerResponse.success();
    }




}
