package com.realworld.repository;

import com.realworld.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository< Author, Long > {

    List< Author> getByName (String name);
}
