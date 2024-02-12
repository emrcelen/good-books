package com.realworld.repository;

import com.realworld.model.BookCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<BookCategories,Long> {
    Optional<BookCategories> findByCategoryName(String categoryName);
}
