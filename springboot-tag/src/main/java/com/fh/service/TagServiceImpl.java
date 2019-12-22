package com.fh.service;

import com.fh.mapper.TagMapper;
import com.fh.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Resource
    private TagMapper tagMapper;

    @Override
    public long queryTagTotalCount() {
        long count = tagMapper.queryTagTotalCount();
        return count;
    }

    @Override
    public List<Tag> queryTagList(Tag tag) {
        return tagMapper.queryTagList(tag);
    }

    @Override
    public void addTag(Tag tag) {
        tagMapper.addTag(tag);
    }

    @Override
    public void deleteTag(Integer id) {
        tagMapper.deleteTag(id);
    }

    @Override
    public Tag toUpdateTag(Integer id) {
        return tagMapper.toUpdateTag(id);
    }

    @Override
    public void updateTag(Tag tag) {
        tagMapper.updateTag(tag);
    }

    @Override
    public Tag queryTagById(Integer id) {
        return tagMapper.queryTagById(id);
    }

    @Override
    public List<Tag> queryTag(Tag tag) {
        return tagMapper.queryTag(tag);
    }

}
