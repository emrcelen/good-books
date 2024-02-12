package com.realworld.controller;

import com.realworld.bo.CategoryBO;
import com.realworld.dto.request.CategoryBasicRequest;
import com.realworld.dto.response.CategoryBasicResponse;
import com.realworld.dto.response.rest.RestValidResponse;
import com.realworld.maper.CategoryControllerMapper;
import com.realworld.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Set;

@RestController
@RequestMapping(path = "category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CategoryBasicRequest request){
        var bo = CategoryControllerMapper.convertToBO(request);
        var boResponse = this.categoryService.create(bo);
        var dto =  CategoryControllerMapper.convertToBasicResponse(boResponse);
        var response = new RestValidResponse.Builder<CategoryBasicResponse>()
                .isSuccess(true)
                .responseDate(LocalDateTime.now())
                .payload(dto)
                .status(HttpStatus.CREATED)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping
    public ResponseEntity<?> findCategory(
            @RequestParam(name = "name", required = false) String categoryName,
            @RequestParam(name = "id", required = false) Long id
    ){
        var bo = this.categoryService.findCategory(categoryName,id);
        var dto = CategoryControllerMapper.convertToBasicResponse(bo);
        var response = new RestValidResponse.Builder<CategoryBasicResponse>()
                .isSuccess(true)
                .responseDate(LocalDateTime.now())
                .payload(dto)
                .status(HttpStatus.OK)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping(path = "{page}/{size}")
    public ResponseEntity<?> findAll(
            @PathVariable(name = "page") int page,
            @PathVariable(name = "size") int size
    ){
        var allCategoryBO = this.categoryService.findAllCategory(page, size);
        var dto = CategoryControllerMapper.convertToBasicResponse(allCategoryBO);
        var response = new RestValidResponse.Builder<Set<CategoryBasicResponse>>()
                .isSuccess(true)
                .responseDate(LocalDateTime.now())
                .payload(dto)
                .status(HttpStatus.OK)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PatchMapping
    public ResponseEntity<?> updateCategory(
            @RequestParam(name = "name", required = false) String categoryName,
            @RequestParam(name = "id", required = false) Long categoryID,
            @RequestBody CategoryBasicRequest request){
        var bo = CategoryControllerMapper.convertToBO(request);
        var boResponse = this.categoryService.update(categoryName,categoryID,bo.categoryName());
        var dto = CategoryControllerMapper.convertToBasicResponse(boResponse);
        var response = new RestValidResponse.Builder<CategoryBasicResponse>()
                .isSuccess(true)
                .responseDate(LocalDateTime.now())
                .payload(dto)
                .status(HttpStatus.OK)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCategoryByName(
            @RequestParam(name = "name", required = false) String categoryName,
            @RequestParam(name = "id", required = false) Long categoryID){
        var boResponse = this.categoryService.delete(categoryName, categoryID);
        var dto = CategoryControllerMapper.convertToBasicResponse(boResponse);
        var response = new RestValidResponse.Builder<CategoryBasicResponse>()
                .isSuccess(true)
                .responseDate(LocalDateTime.now())
                .payload(dto)
                .status(HttpStatus.OK)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



}
