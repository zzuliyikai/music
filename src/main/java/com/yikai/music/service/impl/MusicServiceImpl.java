package com.yikai.music.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yikai.music.controller.PageResult;
import com.yikai.music.dao.MusicDao;
import com.yikai.music.domain.Music;
import com.yikai.music.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicDao musicDao;

    @Override
    public void save(Music music) {
        musicDao.insert(music);
    }

    @Override
    public Music getById(Integer id) {
        return musicDao.selectById(id);
    }

    @Override
    public Music getByName(String name) {
        LambdaQueryWrapper<Music> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Music::getName, name);
        return musicDao.selectOne(wrapper);
    }

    @Override
    public PageResult getMusicList(Integer currentPage, Integer size) {
        Page<Music> myPage = new Page<>(currentPage, size);
        musicDao.selectPage(myPage, null);
        PageResult pageResult = new PageResult();
        pageResult.setList(myPage.getRecords());
        pageResult.setPages(myPage.getPages());
        pageResult.setTotalCount(myPage.getTotal());
        return pageResult;
    }
}
