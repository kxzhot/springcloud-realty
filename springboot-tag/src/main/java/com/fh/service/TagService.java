package com.fh.service;

import com.fh.model.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
public interface TagService {
    long queryTagTotalCount();

    List<Tag> queryTagList(Tag tag);

    void addTag(Tag tag);

    void deleteTag(Integer id);

    Tag toUpdateTag(Integer id);

    void updateTag(Tag tag);

    Tag queryTagById(Integer id);

    List<Tag> queryTag(Tag tag);
}
