package com.example.blog_upgraded.repository;

import com.example.blog_upgraded.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
