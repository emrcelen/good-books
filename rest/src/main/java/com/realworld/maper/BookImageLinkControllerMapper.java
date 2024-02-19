package com.realworld.maper;

import com.realworld.bo.BookImageLinkBO;
import com.realworld.dto.request.BookImageLinkBasicRequest;
import com.realworld.dto.response.BookImageLinkBasicResponse;
import com.realworld.model.BookImageLink;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BookImageLinkControllerMapper {

    public static BookImageLinkBO convertToBO(BookImageLinkBasicRequest request) {
        return new BookImageLinkBO(null
                ,request.thumbnail()
                ,request.smallThumbnail()
                ,request.small()
                ,request.medium()
                ,request.large()
                ,request.extraLarge());
    }

    public static BookImageLinkBasicResponse convertToBasicResponse(BookImageLinkBO bookImageLinkBO) {
        return new BookImageLinkBasicResponse(bookImageLinkBO.id()
                , bookImageLinkBO.thumbnail()
                , bookImageLinkBO.smallThumbnail()
                , bookImageLinkBO.small()
                , bookImageLinkBO.medium()
                , bookImageLinkBO.large()
                , bookImageLinkBO.extraLarge());
    }

    public static Set<BookImageLinkBasicResponse> convertToBasicResponse(Set<BookImageLinkBO> bookImageLinks) {
        return bookImageLinks.stream()
                .map(k -> convertToBasicResponse(k))
                .collect(Collectors.toSet());

    }
}
