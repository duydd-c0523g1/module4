package com.springboot.blog_app.service;

import com.springboot.blog_app.model.Blog;
import com.springboot.blog_app.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }
    @Override
    public List<Blog> findBlogByName(String name) {
        return blogRepository.searchBlogByTitleContaining(name);
    }
    @Override
    public Blog displayBlogById(Integer id) {
        return blogRepository.findBlogById(id);
    }
    @Override
    public void addNewBlog(Blog blog) {
        blogRepository.save(blog);
    }
    @Override
    public void removeBlog(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void updateBlog(Blog blog) {
        blogRepository.save(blog);
    }
}
