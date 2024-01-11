package com.realworld.repository.book;

import com.realworld.model.BookSaleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookSaleInfoRepository extends JpaRepository<BookSaleInfo, UUID> {
    Optional<BookSaleInfo> findByBookId(String bookId);
}
