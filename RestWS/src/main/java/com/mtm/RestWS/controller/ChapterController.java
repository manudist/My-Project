package com.mtm.RestWS.controller;

import com.mtm.library.model.Chapter;
import com.mtm.RestWS.service.ChapterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;
@RestController
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    public static Logger logger = LoggerFactory.getLogger(ChapterController.class);


    @GetMapping("/chapter")
    public List<Chapter> getChapterList() {
        logger.info("getChapterList");
        return chapterService.getChapterList();
    }
    @RolesAllowed("ADMIN")
    @PostMapping("/chapter")
    public Chapter createChapter(@RequestBody Chapter chapterToCreate){
        logger.info("createChapter");
        return chapterService.saveChapter(chapterToCreate);
    }
}

