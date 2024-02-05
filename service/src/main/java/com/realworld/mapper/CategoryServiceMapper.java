package com.realworld.mapper;

import com.realworld.bo.CategoryBO;
import com.realworld.model.Book;
import com.realworld.model.BookCategories;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CategoryServiceMapper {
    public static CategoryBO convertToBO(BookCategories category){
        return new CategoryBO(
                category.getId(),
                category.getCategoryName());
    }
    public static BookCategories convertToPO(CategoryBO category){
        return new BookCategories.Builder()
                .id(category.id())
                .categoryName(category.categoryName())
                .bookCategory(new LinkedHashSet<Book>())
                .build();
    }
    public static CategoryBO updateCategoryNameBO(CategoryBO categoryBO, String newCategoryName){
        return new CategoryBO(
                categoryBO.id(),
                newCategoryName);
    }
    public static Set<CategoryBO> convertToBO(List<BookCategories> categories){
        return categories.stream()
                .map(k -> convertToBO(k))
                .collect(Collectors.toSet());
    }


}
