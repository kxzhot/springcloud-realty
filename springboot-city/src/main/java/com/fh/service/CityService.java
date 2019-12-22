package com.fh.service;

import com.fh.model.City;

import java.util.List;

public interface CityService {
    City queryById(Integer id);

    List<City> queryList();

    void updateCity(City c);

    void addCity(City c);

    void deleteNode(Integer id);

    List<City> queryByPid(Integer pid);

    String queryCityData(Integer proId, Integer areaId, Integer comId);
}
