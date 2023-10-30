package com.springboot.blog_app.service;

import com.springboot.blog_app.model.Blog;
import com.springboot.blog_app.model.Category;
import com.springboot.blog_app.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }
    @Override
    public List<Blog> findBlogByName(String name) {
        return blogRepository.searchBlogByTitleContaining(name);
    }

    @Override
    public List<Blog> findBlogByCategory(String name) {
        return blogRepository.searchBlogByCategoryName(name);
    }

    @Override
    public List<Blog> searchBlogByCategoryId(Integer id) {
        return blogRepository.searchBlogByCategoryId(id);
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

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }
}
