package com.springboot.blog_app.service;

import com.springboot.blog_app.model.Category;
import com.springboot.blog_app.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements  ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void addCategory(Category category) {

    }

    @Override
    public void deleteCategory(Integer id) {

    }

    @Override
    public void updateCategory(Category category) {

    }
}
