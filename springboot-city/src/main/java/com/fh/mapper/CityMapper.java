package com.fh.mapper;

import com.fh.model.City;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CityMapper {
    City queryById(Integer id);

    List<City> queryList();

    void updateCity(City c);

    void addCity(City c);

    void deleteNode(Integer id);

    List<City> queryByPid(Integer pid);

    String queryCityData(Map m);
}
