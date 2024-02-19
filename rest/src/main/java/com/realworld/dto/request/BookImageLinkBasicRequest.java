package com.realworld.dto.request;

public record BookImageLinkBasicRequest(
        String thumbnail,
        String smallThumbnail,
        String small,
        String medium,
        String large,
        String extraLarge

        //BookBO book,
){}

