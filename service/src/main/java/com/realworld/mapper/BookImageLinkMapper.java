package com.realworld.mapper;

import com.realworld.bo.BookImageLinkBO;
import com.realworld.model.BookImageLink;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class BookImageLinkMapper {

    public static BookImageLink convertToPO(BookImageLinkBO bookImageLinkBO){
        return new BookImageLink.Builder()
                .thumbnail(bookImageLinkBO.thumbnail())
                .smallThumbnail(bookImageLinkBO.smallThumbnail())
                .small(bookImageLinkBO.small())
                .medium(bookImageLinkBO.medium())
                .large(bookImageLinkBO.large())
                .extraLarge(bookImageLinkBO.extraLarge())
                .build();
    }

    public static BookImageLinkBO convertToBO(BookImageLink bookImageLinkPO) {
        return new BookImageLinkBO(bookImageLinkPO.getId()
                ,bookImageLinkPO.getThumbnail()
                ,bookImageLinkPO.getSmallThumbnail()
                ,bookImageLinkPO.getSmall()
                ,bookImageLinkPO.getMedium()
                ,bookImageLinkPO.getLarge()
                ,bookImageLinkPO.getExtraLarge());
    }
    public static Set<BookImageLinkBO> convertToBO(List<BookImageLink> bookImageLinksPO){
        return bookImageLinksPO.stream()
                .map(k -> convertToBO(k))
                .collect(Collectors.toSet());
    }
}
