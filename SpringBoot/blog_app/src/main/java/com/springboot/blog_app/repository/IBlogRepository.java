package com.springboot.blog_app.repository;

import com.springboot.blog_app.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(nativeQuery = true, value = "select * from blogs where id = :param")
    Blog findBlogById(@Param("param") Integer id);

    @Query(nativeQuery = true, value = "select * from blogs where name like :param2")
    List<Blog> findBlogByName(@Param("param2") String name);
}
