package com.mtm.RestWS.service;

import com.mtm.RestWS.controller.VolumeController;
import com.mtm.library.model.Volume;
import com.mtm.RestWS.repository.VolumeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolumeService {

    private final Logger logger = LoggerFactory.getLogger(VolumeController.class);

    @Autowired
    private VolumeRepository volumeRepository;

    public List<Volume> getVolumeList() {
        return volumeRepository.findAll();
    }

    public Volume saveVolume(Volume volumeToBeSaved) {
        return volumeRepository.save(volumeToBeSaved);
    }
}
