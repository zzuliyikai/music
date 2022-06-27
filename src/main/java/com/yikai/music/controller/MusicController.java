package com.yikai.music.controller;


import com.yikai.music.domain.Music;
import com.yikai.music.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

// nohup java -jar NettyAPI.jar &  启动程序并且
@RestController
@RequestMapping("/musics")
@ResponseBody
public class MusicController {

    @Autowired
    private MusicService musicService;

    @Value("${localPath}")
    private String path;


    @GetMapping("/{id}")
    public Result getMusicById(@PathVariable Integer id) {
        Result result = new Result();
        result.setDate(musicService.getById(id));
        return result;
    }

    @GetMapping()
    public Result getMusicByName(String name) {
        Result result = new Result();
        result.setDate(musicService.getByName(name));
        return result;
    }

    @GetMapping("/getMusicList")
    public Result getMusicList(Integer page, Integer pageSize) {
        Result result = new Result();
        result.setDate(musicService.getMusicList(page, pageSize));
        return result;
    }

    //文件上传
    @PostMapping(path = "/upload")
    public Result upload(@RequestParam("file") MultipartFile file) {
        //获取原始文件名
        String originalFilename = file.getOriginalFilename();
        File localFile = new File(path + originalFilename);
        try {
            //直接将文件拷贝到指定位置
            file.transferTo(localFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Music music = new Music();
        music.setName(originalFilename);
        music.setPath(originalFilename);
        musicService.save(music);

        Result result = new Result();
        result.setDate(localFile.exists());
        return result;
    }

}
