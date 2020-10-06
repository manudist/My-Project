package com.mtm.library.repository;

import com.mtm.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ReaderRepository extends JpaRepository<Reader, UUID> {
    Optional<Reader> findReaderByName(String name);
}
