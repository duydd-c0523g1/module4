package com.library_manager.service;

import com.library_manager.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    Page<Book> findAllBookPage(Pageable pageable);
    List<Book> findAllBookList();
    Book findBookById(Integer id);
    int getCode();
    Book findBookByRentCodes(int code);
    void saveBook(Book book);
    Book findBook(Integer id);
}
