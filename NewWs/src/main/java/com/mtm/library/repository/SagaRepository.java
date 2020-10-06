package com.mtm.library.repository;

import com.mtm.model.Author;
import com.mtm.model.Saga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface SagaRepository extends JpaRepository<Saga, UUID> {
    Optional<Saga> findSagaByName(String name);
}
