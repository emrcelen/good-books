package com.realworld.repository.book;

import com.realworld.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findByTitle(String title);
    List<Book> findByPublisher(String title);
}
