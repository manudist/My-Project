package com.mtm.RestWS.service;
import com.mtm.RestWS.controller.ChapterController;
import com.mtm.RestWS.model.Chapter;
import com.mtm.RestWS.repository.ChapterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterService {
    private final Logger logger = LoggerFactory.getLogger(ChapterService.class);

    @Autowired
    private ChapterRepository chapterRepository;


    public List<Chapter> getChapterList() {
        return chapterRepository.findAll();
    }

    public Chapter getChapterFromName(String name) {
        logger.info("getChapterFromName");
        return chapterRepository.findChapterByName(name);
    }

    public Chapter saveChapter(Chapter chapterToBeSaved) {
        return chapterRepository.save(chapterToBeSaved);
    }
}

