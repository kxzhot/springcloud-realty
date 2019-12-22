package com.fh.service;

import com.fh.mapper.CityMapper;
import com.fh.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CityServiceimpl implements CityService{
    @Autowired
    private CityMapper cityMapper;

    @Override
    public City queryById(Integer id) {
        return cityMapper.queryById(id);
    }

    @Override
    public List<City> queryList() {
        return cityMapper.queryList();
    }

    @Override
    public void updateCity(City c) {
        cityMapper.updateCity(c);
    }

    @Override
    public void addCity(City c) {
        cityMapper.addCity(c);
    }

    @Override
    public void deleteNode(Integer id) {
        cityMapper.deleteNode(id);
    }

    @Override
    public List<City> queryByPid(Integer pid) {
        return cityMapper.queryByPid(pid);
    }

    @Override
    public String queryCityData(Integer proId, Integer areaId, Integer comId) {
        Map m=new HashMap();
        m.put("proId",proId);
        m.put("areaId",areaId);
        m.put("comId",comId);
        return cityMapper.queryCityData(m);
    }
}
