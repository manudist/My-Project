package com.mtm.RestWS.repository;

import com.mtm.RestWS.model.Volume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface VolumeRepository extends JpaRepository<Volume,UUID> {

}
