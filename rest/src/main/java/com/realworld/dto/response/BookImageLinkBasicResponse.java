package com.realworld.dto.response;

public record BookImageLinkBasicResponse(
        java.util.UUID id,
        String thumbnail,
        String smallThumbnail,
        String small,
        String medium,
        String large,
        String extraLarge

        //BookBO book,
){

}

