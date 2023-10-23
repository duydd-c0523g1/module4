package com.example.blog_upgraded.service;

import com.example.blog_upgraded.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findByTitleContaining(Pageable pageable, String keyword);

    void addBlog(Blog blog);
    void deleteBlog(Integer id);
}
