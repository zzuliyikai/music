package com.yikai.music.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yikai.music.domain.Music;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MusicDao extends BaseMapper<Music> {
}
