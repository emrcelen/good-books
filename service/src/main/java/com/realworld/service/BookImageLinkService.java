package com.realworld.service;

import com.realworld.bo.BookImageLinkBO;
import com.realworld.exception.CategoryNotFoundException;
import com.realworld.mapper.BookImageLinkMapper;
import com.realworld.model.BookImageLink;
import com.realworld.repository.book.BookImageLinkRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class BookImageLinkService {

    private final BookImageLinkRepository bookImageLinkRepository;

    public BookImageLinkService(BookImageLinkRepository bookImageLinkRepository){
        this.bookImageLinkRepository = bookImageLinkRepository;
    }

    public Set<BookImageLinkBO> findAllBookImageLink(int page, int pageSize){
        if(findAllPageableControl(page,pageSize)){
            Pageable pageable = PageRequest.of(page-1,pageSize, Sort.by("id").ascending());
            List<BookImageLink> bookImageLinksPO = this.bookImageLinkRepository.findAll(pageable).toList();
            if(!bookImageLinksPO.isEmpty()){
                Set<BookImageLinkBO> bookImageLinksBO = BookImageLinkMapper.convertToBO(bookImageLinksPO);
                return bookImageLinksBO;
            }
            throw new CategoryNotFoundException(
                    "I couldn't find any category information based on the parameters you provided; please repeat your request with different values.");
        }
        throw new IllegalArgumentException
                ("An unexpected error occurred, please try again later or contact the system administrator.");

    }
    public BookImageLinkBO findByBookImageLink(String bookImageLinkId){
        if (bookImageLinkId == null && bookImageLinkId.isEmpty()){
            BookImageLink bookImageLink = this.bookImageLinkRepository.findByBookId(bookImageLinkId).orElse(null);
            return BookImageLinkMapper.convertToBO(bookImageLink);
        }
        throw new IllegalArgumentException
                ("An unexpected error occurred, please try again later or contact the system administrator.");

    }



    public BookImageLinkBO save(BookImageLinkBO bookImageLinkBO) {

        BookImageLink bookImageLinkPO = BookImageLinkMapper.convertToPO(bookImageLinkBO);
        bookImageLinkPO = this.bookImageLinkRepository.save(bookImageLinkPO);
        return BookImageLinkMapper.convertToBO(bookImageLinkPO);


    }


    private boolean findAllPageableControl(int page, int pageSize) {
        return page > 0 && pageSize > 0;
    }

}
