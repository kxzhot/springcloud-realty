package com.fh.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.biz.TypeService;
import com.fh.controller.CityService;
import com.fh.mapper.HouseMapper;
import com.fh.model.HouseInfo;
import com.fh.ser.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class HouseServiceImpl implements  HouseService {
    @Autowired
    private HouseMapper houseMapper;
    @Autowired
    private TypeService typeService;
    @Autowired
    private CityService cityService;
    @Autowired
    private TagService tagService;

    @Override
    public Long queryTotalCount(HouseInfo m) {
        return houseMapper.quertToyalCount(m);
    }

    @Override
    public List<HouseInfo> queryList(HouseInfo m) {
        List<HouseInfo> houseInfos = houseMapper.queryList(m);
        for(HouseInfo houseInfo:houseInfos){
              //根据id查询类型
            String byId = typeService.findById(houseInfo.getTypeid());
            //添加类型信息
            houseInfo.setTypename(byId);
              // 查询配置
            String string = tagService.queryTagById(houseInfo.getDeployid());
            //添加配置
            houseInfo.setDeplovname(string);
              //查询地区
            String areaString = cityService.queryCityData(houseInfo.getProvinceid(), houseInfo.getCityid(), houseInfo.getCountyid());
            //添加地区
            houseInfo.setArdessname(areaString);

        }
        return  houseInfos;
    }



    @Override
    public void add(HouseInfo houseInfo) {
        Date date=new Date();
        houseInfo.setCreatetime(date);
        houseMapper.insert(houseInfo);
    }

    @Override
    public void deletebyId(HouseInfo houseInfo) {
        QueryWrapper<HouseInfo> queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",houseInfo.getId());
        houseMapper.delete(queryWrapper);
      }

    @Override
    public void update(HouseInfo houseInfo) {
        houseMapper.updateById(houseInfo);
    }
}
