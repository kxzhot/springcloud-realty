package com.fh.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.websocket.server.PathParam;

@FeignClient(value = "springboot-tag",fallback = MyFallBack.class)
public interface TagService {

    //根据id查找
    @RequestMapping(value = "/tag/queryTagById/{id}",method = RequestMethod.GET)
    String queryTagById(@PathParam("id") Integer id);
}
