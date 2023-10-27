package com.library_manager.controller;

import com.library_manager.model.Book;
import com.library_manager.model.RentalContract;
import com.library_manager.service.IBookService;
import com.library_manager.service.IRentCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IRentCodeService rentCodeService;

    @GetMapping
    public ModelAndView showHomePage(@PageableDefault(value = 4) Pageable pageable) {
        return new ModelAndView("home", "bookList", bookService.findAllBookPage(pageable));
    }
    @GetMapping("/{id}/view-details")
    public ModelAndView viewDetails(@PathVariable Integer id) {
        Book book = bookService.findBookById(id);
        return new ModelAndView("book-details", "book", book);
    }
    @GetMapping("/rent/{id}")
    public ModelAndView rentBook(@PathVariable Integer id, Model model) {
        Book book = bookService.findBookById(id);
        if (book.getRemaining() > 0) {
            book.setRemaining(book.getRemaining() - 1);
            int code = bookService.getCode();
            RentalContract rentalContract = new RentalContract(code, book);
            rentCodeService.saveRentCode(rentalContract);
            model.addAttribute("book", book);
            return new ModelAndView("rent-result", "code", code);
        } else {
//            throw new NullPointerException();
            return new ModelAndView("error", "error", "This title is not available");
        }
    }
    @PostMapping("/return-book")
    public ModelAndView returnBook(@RequestParam int code) {
        RentalContract contract = rentCodeService.findRentCode(code);
        if ( contract == null){
            return new ModelAndView("error", "error", "Code does not exist");
        } else {
            Book book = contract.getBook();
            book.setRemaining(book.getRemaining() + 1);
            bookService.saveBook(book);
            return new ModelAndView("redirect:/");
        }
    }
//        List<Book> bookList = bookService.findAllBookList();
//        RentalContract contract = rentCodeService.findRentCode(code);
//        for (Book book : bookList) {
//            if (Objects.equals(book.getId(), contract.getBook().getId())) {
//                rentCodeService.deleteRentCode(contract);
//                book.setRemaining(book.getRemaining() + 1);
//                bookService.saveBook(book);
//                return new ModelAndView("home", "result", "Success!");
//            } else {
//                return new ModelAndView("error", "error", "Code does not exist");
//            }
//        }
//        return null;
//    }
}
