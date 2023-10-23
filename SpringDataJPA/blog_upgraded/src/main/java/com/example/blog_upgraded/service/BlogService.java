package com.example.blog_upgraded.service;

import com.example.blog_upgraded.model.Blog;
import com.example.blog_upgraded.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findByTitleContaining(Pageable pageable, String keyword) {
        return blogRepository.findByTitleContaining(pageable, keyword);
    }

    @Override
    public void addBlog(Blog blog) {
        blogRepository.save(blog);
    }
    @Override
    public void deleteBlog(Integer id) {
        blogRepository.deleteById(id);
    }
}
