package com.mtm.RestWS.repository;
import com.mtm.library.model.Author;
import com.mtm.library.model.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;


@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {

    Author findAuthorByName(String name);
    @Query("SELECT author FROM Author author WHERE author.birthplace = :birthplace")
    Collection<Author> getAuthorFromPlace(@Param("birthplace") String birthplace);

}