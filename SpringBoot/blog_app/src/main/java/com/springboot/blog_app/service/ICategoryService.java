package com.springboot.blog_app.service;

import com.springboot.blog_app.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAllCategory();
    void addCategory(Category category);
    void deleteCategory(Integer id);
    void updateCategory(Category category);
}
