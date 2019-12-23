package com.fh.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.fh.common.ServerResponse;
import com.fh.model.HouseInfo;
import com.fh.service.HouseService;
import com.fh.util.dowFileImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("house")
public class HouseController {
    @Autowired
    private HouseService houseService;

    /**
     * 查询
     * @param m
     * @return
     */
    @RequestMapping("queryList")
    public ServerResponse queryList(HouseInfo m){
        Long totalCount = houseService.queryTotalCount(m);
        List<HouseInfo> list =   houseService.queryList(m);
        Map map = new HashMap();
        map.put("data",list);
        map.put("recordsTotal",totalCount);
        map.put("recordsFiltered",totalCount);
        map.put("draw",m.getDraw());
        return  ServerResponse.success(map);
    }

    /**
     *  增加
     * @param houseInfo
     */
    @RequestMapping("add")
    public  ServerResponse add(HouseInfo houseInfo){
        houseService.add(houseInfo);
        return ServerResponse.success();
    }

    /**
     * 根据id删除
     * @param houseInfo
     */
    @RequestMapping("deletebyid")
    public ServerResponse  deleteById(HouseInfo houseInfo){
        houseService.deletebyId(houseInfo);
       return  ServerResponse.success();
    }


    @RequestMapping("update")
    public ServerResponse update(HouseInfo houseInfo){
        houseService.update(houseInfo);
        return  ServerResponse.success();
    }

    /**
     * 图片上传
     * @param img
     * @param request
     * @return
     */
    @RequestMapping(value = "fileInput")
    @ResponseBody
    public String fileInput(@RequestParam("img") CommonsMultipartFile img, HttpServletRequest request){

        Map m= null;
        try {
            m = dowFileImg.getFilePath(request,img);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String string = JSON.toJSONString(m);
        return string;
    }

}
