package com.mtm.RestWS.controller;

import com.mtm.library.model.Author;
import com.mtm.library.model.Chapter;
import com.mtm.RestWS.service.ChapterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Collection;
import java.util.List;
@RestController
public class ChapterController {

    public static Logger logger = LoggerFactory.getLogger(ChapterController.class);

    @Autowired
    private ChapterService chapterService;

    @GetMapping("/chapter")
    public List<Chapter> getChapterList() {
        logger.info("getChapterList");
        return chapterService.getChapterList();
    }
    @PostMapping("/chapter")
    public Chapter createChapter(@RequestBody Chapter chapterToCreate){
        logger.info("createChapter");
        return chapterService.saveChapter(chapterToCreate);
    }
    @GetMapping("/chapternumber/{chapterNumber}")
    public Collection<Chapter> getChapterFromNumber(@PathVariable int chapterNumber) {
        logger.info("getChapterFromNumber");
        return chapterService.getChapterFromNumber(chapterNumber);
    }
}

