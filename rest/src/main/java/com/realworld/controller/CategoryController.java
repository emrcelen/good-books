package com.realworld.controller;

import com.realworld.bo.CategoryBO;
import com.realworld.dto.request.CategoryBasicRequest;
import com.realworld.dto.response.CategoryBasicResponse;
import com.realworld.maper.CategoryControllerMapper;
import com.realworld.service.CategoryService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path = "category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public CategoryBasicResponse create(@RequestBody CategoryBasicRequest request){
        var bo = CategoryControllerMapper.convertToBO(request);
        var boResponse = this.categoryService.create(bo);
        var response =  CategoryControllerMapper.convertToBasicResponse(boResponse);
        return response;
    }
    @GetMapping
    public CategoryBasicResponse findCategory(
            @RequestParam(name = "name", required = false) String categoryName,
            @RequestParam(name = "id", required = false) Long id
    ){
        var bo = this.categoryService.findCategory(categoryName,id);
        var response = CategoryControllerMapper.convertToBasicResponse(bo);
        return response;
    }
    @GetMapping(path = "{page}/{size}")
    public Set<CategoryBasicResponse> findAll(
            @PathVariable(name = "page") int page,
            @PathVariable(name = "size") int size
    ){
        var allCategoryBO = this.categoryService.findAllCategory(page, size);
        var response = CategoryControllerMapper.convertToBasicResponse(allCategoryBO);
        return response;
    }
    @PatchMapping
    public CategoryBasicResponse updateCategory(
            @RequestParam(name = "name", required = false) String categoryName,
            @RequestParam(name = "id", required = false) Long categoryID,
            @RequestBody CategoryBasicRequest request){
        var bo = CategoryControllerMapper.convertToBO(request);
        var boResponse = this.categoryService.update(categoryName,categoryID,bo.categoryName());
        var response = CategoryControllerMapper.convertToBasicResponse(boResponse);
        return response;
    }

    @DeleteMapping
    public CategoryBasicResponse deleteCategoryByName(
            @RequestParam(name = "name", required = false) String categoryName,
            @RequestParam(name = "id", required = false) Long categoryID){
        var boResponse = this.categoryService.delete(categoryName, categoryID);
        var response = CategoryControllerMapper.convertToBasicResponse(boResponse);
        return response;
    }



}
