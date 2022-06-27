package com.yikai.music.service;

import com.yikai.music.controller.PageResult;
import com.yikai.music.domain.Music;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface MusicService {

    void save(Music music);

    Music getById(Integer id);

    Music getByName(String name);

    PageResult getMusicList(Integer page, Integer pageSize);

}
