package com.fh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.model.HouseInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HouseMapper extends BaseMapper<HouseInfo> {
    Long quertToyalCount(HouseInfo m);

    List<HouseInfo> queryList(HouseInfo m);
}
