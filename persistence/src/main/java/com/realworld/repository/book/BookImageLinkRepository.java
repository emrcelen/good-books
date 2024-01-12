package com.realworld.repository.book;

import com.realworld.model.BookImageLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookImageLinkRepository extends JpaRepository<BookImageLink, UUID> {
    Optional<BookImageLink> findByBookId(String bookId);
}
