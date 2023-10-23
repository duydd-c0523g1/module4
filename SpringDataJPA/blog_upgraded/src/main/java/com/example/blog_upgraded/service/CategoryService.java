package com.example.blog_upgraded.service;

import com.example.blog_upgraded.model.Category;
import com.example.blog_upgraded.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> getCategoryList() {
        return categoryRepository.findAll();
    }
}
