package com.fh.service;

import com.fh.model.HouseInfo;

import java.util.List;

public interface HouseService {
    Long queryTotalCount(HouseInfo m);

    List<HouseInfo> queryList(HouseInfo m);

    void add(HouseInfo houseInfo);

    void deletebyId(HouseInfo houseInfo);

    void update(HouseInfo houseInfo);
}
