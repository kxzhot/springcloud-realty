package com.fh.controller;

import com.fh.common.DataTableResult;
import com.fh.common.ServerResponse;
import com.fh.model.Tag;
import com.fh.service.TagService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("tag")
public class TagController {
    @Resource
    private TagService tagService;

    @RequestMapping("queryTagList")
    public ServerResponse queryTagList(Tag tag) {
        long totalCount = tagService.queryTagTotalCount();
        List<Tag> tagList = tagService.queryTagList(tag);
        DataTableResult dataTableResult = new DataTableResult(tag.getDraw(), totalCount, totalCount, tagList);
        return ServerResponse.success(dataTableResult);
    }
    @RequestMapping("queryTag")
    public ServerResponse queryTag(Tag tag) {
        List<Tag> tagList = tagService.queryTag(tag);
        return ServerResponse.success(tagList);
    }

    @RequestMapping("addTag")
    public ServerResponse addTag(Tag tag) {
        tagService.addTag(tag);
        return ServerResponse.success();
    }

    @RequestMapping("deleteTag")
    public ServerResponse deleteTag(Integer id) {
        tagService.deleteTag(id);
        return ServerResponse.success();
    }

    @RequestMapping("toUpdateTag")
    public ServerResponse toUpdateTag(Integer id) {
        Tag tag = tagService.toUpdateTag(id);
        return ServerResponse.success(tag);
    }

    @RequestMapping("updateTag")
    public ServerResponse updateTag(Tag tag) {
        tagService.updateTag(tag);
        return ServerResponse.success();
    }

    @RequestMapping("queryTagById")
    public String queryTagById(Integer id) {
        Tag tag = tagService.queryTagById(id);
        return tag.getTag();
    }


}
