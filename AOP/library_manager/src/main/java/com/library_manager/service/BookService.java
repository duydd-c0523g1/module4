package com.library_manager.service;

import com.library_manager.model.Book;
import com.library_manager.model.RentalContract;
import com.library_manager.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;
    @Autowired
    private IRentCodeService rentCodeService;

    @Override
    public Page<Book> findAllBookPage(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }


    @Override
    public List<Book> findAllBookList() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(Integer id) {
        return bookRepository.findBookById(id);
    }

    @Override
    public int getCode() {
        Random random = new Random();
        List<RentalContract> codeList;
        while (true) {
            int code = random.nextInt(90000) + 1000;
            codeList = rentCodeService.checkIfCodeExist(code);
            if (codeList.isEmpty()) {
                return code;
            }
        }
    }

    @Override
    public Book findBookByRentCodes(int code) {
        return bookRepository.findBookByRentCode(code);
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findBook(Integer id) {
        return bookRepository.findBookById(id);
    }

}
