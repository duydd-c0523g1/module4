package com.library_manager.repository;

import com.library_manager.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findAll(Pageable pageable);
    Book findBookById(Integer id);
    @Query(nativeQuery = true, value = "SELECT * FROM books WHERE rentalContracts = :param")
    Book findBookByRentCode(@Param("param") int code);
}

