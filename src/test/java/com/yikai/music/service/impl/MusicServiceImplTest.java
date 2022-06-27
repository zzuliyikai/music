package com.yikai.music.service.impl;

import com.yikai.music.dao.MusicDao;
import com.yikai.music.domain.Music;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MusicServiceImplTest {

    @Autowired
    private MusicDao musicDao;

    @Test
    void save() {
        Music music = new Music();
        music.setName("hahah");
        music.setPath("hahah");
        musicDao.insert(music);
    }
}