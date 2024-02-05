package com.realworld.service;

import com.realworld.bo.CategoryBO;
import com.realworld.exception.CategoryAlreadyCreatedException;
import com.realworld.exception.CategoryNotFoundException;
import com.realworld.mapper.CategoryServiceMapper;
import com.realworld.model.BookCategories;
import com.realworld.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryBO create(CategoryBO categoryBO) {
        if (categoryCreateControl(categoryBO)) {
            BookCategories categoryPO = CategoryServiceMapper.convertToPO(categoryBO);
            categoryPO = this.categoryRepository.save(categoryPO);
            return CategoryServiceMapper.convertToBO(categoryPO);
        }
        throw new IllegalArgumentException
                ("An unexpected error occurred, please try again later or contact the system administrator.");
    }
    public CategoryBO update(String categoryName, Long categoryID, String newCategoryName){
        if(categoryName != null && !categoryName.isEmpty() && categoryID == null)
            return updateByCategoryName(categoryName,newCategoryName);
        else if(categoryID != null && categoryID > 0 && categoryName == null)
            return updateByCategoryID(categoryID,newCategoryName);
        throw new IllegalArgumentException
                ("An unexpected error occurred, please try again later or contact the system administrator.");
    }
    public CategoryBO delete(String categoryName, Long categoryID){
        if(categoryID != null && categoryID > 0 && categoryName == null)
            return deleteByCategoryID(categoryID);
        else if(categoryName != null && !categoryName.isEmpty() && categoryID == null)
            return deleteByCategoryName(categoryName);
        throw new IllegalArgumentException
                ("An unexpected error occurred, please try again later or contact the system administrator.");
    }

    public CategoryBO findCategory(String categoryName, Long categoryID){
        if(categoryID != null && categoryID > 0 && categoryName == null)
            return findByCategoryID(categoryID);
        else if(categoryName != null && !categoryName.isEmpty() && categoryID == null)
            return findByCategoryName(categoryName);
        throw new IllegalArgumentException
                ("An unexpected error occurred, please try again later or contact the system administrator.");
    }
    public Set<CategoryBO> findAllCategory(int page, int pageSize) {
        if (findAllPageableControl(page, pageSize)) {
            Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by(Sort.Order.by("id")).ascending());
            List<BookCategories> categoriesPO = this.categoryRepository.findAll(pageable).toList();
            if (!categoriesPO.isEmpty()) {
                Set<CategoryBO> categoriesBO = CategoryServiceMapper.convertToBO(categoriesPO);
                return categoriesBO;
            }
            throw new CategoryNotFoundException(
                    "I couldn't find any category information based on the parameters you provided; please repeat your request with different values.");
        }
        throw new IllegalArgumentException
                ("An unexpected error occurred, please try again later or contact the system administrator.");
    }

    private CategoryBO updateByCategoryName(String categoryName, String newCategoryName) {
        if (categoryName != null && !categoryName.isEmpty() && newCategoryName != null && !newCategoryName.isEmpty()) {
            if (!categoryName.equalsIgnoreCase(newCategoryName)) {
                CategoryBO categoryBO = findByCategoryName(categoryName);
                categoryBO = CategoryServiceMapper.updateCategoryNameBO(categoryBO, newCategoryName);
                if (categoryCreateControl(categoryBO)) {
                    BookCategories categoryPO = CategoryServiceMapper.convertToPO(categoryBO);
                    categoryPO = this.categoryRepository.save(categoryPO);
                    return CategoryServiceMapper.convertToBO(categoryPO);
                }
                throw new CategoryAlreadyCreatedException
                        ("The category you are trying to update is rejected because it is registered in the system");
            }
            throw new IllegalArgumentException
                    ("The category name you are trying to update is rejected because it is the same as the new category name");
        }
        throw new IllegalArgumentException
                ("An unexpected error occurred, please try again later or contact the system administrator.");
    }
    private CategoryBO updateByCategoryID(Long categoryID, String newCategoryName) {
        if (categoryID != null && categoryID > 0 && newCategoryName != null && !newCategoryName.isEmpty()) {
            CategoryBO categoryBO = findByCategoryID(categoryID);
            if (!categoryBO.categoryName().equalsIgnoreCase(newCategoryName)) {
                categoryBO = CategoryServiceMapper.updateCategoryNameBO(categoryBO, newCategoryName);
                if (categoryCreateControl(categoryBO)) {
                    BookCategories categoryPO = CategoryServiceMapper.convertToPO(categoryBO);
                    categoryPO = this.categoryRepository.save(categoryPO);
                    return CategoryServiceMapper.convertToBO(categoryPO);
                }
                throw new CategoryAlreadyCreatedException
                        ("The category you are trying to update is rejected because it is registered in the system");
            }
            throw new IllegalArgumentException
                    ("The category name you are trying to update is rejected because it is the same as the new category name");
        }
        throw new IllegalArgumentException
                ("An unexpected error occurred, please try again later or contact the system administrator.");
    }
    private CategoryBO findByCategoryName(String categoryName) {
        if (categoryName != null && !categoryName.isEmpty()) {
            BookCategories category = this.categoryRepository.findByCategoryName(categoryName)
                    .orElseThrow(
                            () -> new CategoryNotFoundException(String
                                    .format("The requested category %s could not be found.", categoryName))
                    );
            return CategoryServiceMapper.convertToBO(category);
        } else
            throw new IllegalArgumentException
                    ("An unexpected error occurred, please try again later or contact the system administrator.");
    }
    private CategoryBO findByCategoryID(Long categoryID) {
        if (categoryID != null && categoryID > 0) {
            BookCategories category = this.categoryRepository.findById(categoryID)
                    .orElseThrow(
                            () -> new CategoryNotFoundException(String
                                    .format("The category with the requested ID %d could not be found.", categoryID))
                    );
            return CategoryServiceMapper.convertToBO(category);
        } else
            throw new IllegalArgumentException
                    ("An unexpected error occurred, please try again later or contact the system administrator.");
    }
    private CategoryBO deleteByCategoryName(String categoryName) {
        CategoryBO categoryBO = findByCategoryName(categoryName);
        this.categoryRepository.deleteById(categoryBO.id());
        return categoryBO;
    }
    private CategoryBO deleteByCategoryID(Long categoryID) {
        CategoryBO categoryBO = findByCategoryID(categoryID);
        this.categoryRepository.deleteById(categoryBO.id());
        return categoryBO;
    }
    private boolean categoryCreateControl(CategoryBO category) {
        //Todo: kitaplar için de set tanımının oluşup oluşmadığına bak.
        if (category != null && category.categoryName() != null && !category.categoryName().isEmpty()) {
            BookCategories categoryPO = this.categoryRepository.findByCategoryName(category.categoryName())
                    .orElse(null);
            return categoryPO == null ? true : false;
        }
        throw new IllegalArgumentException("Kanka sen bana yanlış bir şeyler verdin");
    }
    private boolean findAllPageableControl(int page, int pageSize) {
        return page > 0 && pageSize > 0 ? true : false;
    }
}
