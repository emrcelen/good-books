package com.realworld.maper;

import com.realworld.bo.CategoryBO;
import com.realworld.dto.request.CategoryBasicRequest;
import com.realworld.dto.response.CategoryBasicResponse;

import java.util.Set;
import java.util.stream.Collectors;

public class CategoryControllerMapper {
    public static CategoryBO convertToBO (CategoryBasicRequest request){
        return new CategoryBO(
                null,
                request.categoryName()
        );
    }
    public static CategoryBasicResponse convertToBasicResponse(CategoryBO categoryBO){
        return new CategoryBasicResponse(
                categoryBO.id(),
                categoryBO.categoryName()
        );
    }
    public static Set<CategoryBasicResponse> convertToBasicResponse(Set<CategoryBO> categories){
        return categories.stream()
                .map(k -> convertToBasicResponse(k))
                .collect(Collectors.toSet());
    }
}
