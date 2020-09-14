package com.mtm.RestWS.controller;
import com.mtm.library.model.Volume;
import com.mtm.RestWS.service.VolumeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
public class VolumeController {

    private final Logger logger = LoggerFactory.getLogger(VolumeController.class);

    @Autowired
    private VolumeService volumeService;

    @GetMapping("/volume")
    public List<Volume> getVolumeList() {
        logger.info("getVolumeList");
        return volumeService.getVolumeList();
    }

    @PostMapping("/volume")
    public Volume createVolume(@RequestBody Volume volumeToCreate){
        logger.info("createVolume");
        return volumeService.saveVolume(volumeToCreate);
    }

}
