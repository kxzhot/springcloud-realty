package com.fh.mapper;

import com.fh.model.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TagMapper {
    long queryTagTotalCount();

    List<Tag> queryTagList(Tag tag);

    void addTag(Tag tag);

    void deleteTag(Integer id);

    Tag toUpdateTag(Integer id);

    void updateTag(Tag tag);

    Tag queryTagById(Integer id);

    List<Tag> queryTag(Tag tag);


}
