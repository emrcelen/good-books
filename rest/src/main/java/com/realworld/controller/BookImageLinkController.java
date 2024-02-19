package com.realworld.controller;

import com.realworld.dto.response.BookImageLinkBasicResponse;
import com.realworld.dto.response.rest.RestValidResponse;
import com.realworld.maper.BookImageLinkControllerMapper;
import com.realworld.model.BookImageLink;
import com.realworld.service.BookImageLinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Set;

@RestController
@RequestMapping("bookImageLink")
public class BookImageLinkController {

    private final BookImageLinkService bookImageLinkService;

    public BookImageLinkController(BookImageLinkService bookImageLinkService){
        this.bookImageLinkService = bookImageLinkService;
    }

    @GetMapping("{page}/{size}")
    public ResponseEntity<?> findAll(@PathVariable("page") int page ,
                                     @PathVariable("size") int size){
        var allBookImageLinkBO = this.bookImageLinkService.findAllBookImageLink(page,size);
        var dto = BookImageLinkControllerMapper.convertToBasicResponse(allBookImageLinkBO);
        var response = new RestValidResponse.Builder<Set<BookImageLinkBasicResponse>>()
                .isSuccess(true)
                .responseDate(LocalDateTime.now())
                .payload(dto)
                .status(HttpStatus.OK)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }


}
