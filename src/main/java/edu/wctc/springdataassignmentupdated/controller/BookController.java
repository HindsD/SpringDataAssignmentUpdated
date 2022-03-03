package edu.wctc.springdataassignmentupdated.controller;

import edu.wctc.springdataassignmentupdated.entity.Book;
import edu.wctc.springdataassignmentupdated.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired
    BookController(BookService books){
        this.bookService = books;
    }

    @PostMapping("/update")
    public String processSighting(Model model,
                                  @Valid @ModelAttribute Book book,
                                  BindingResult bindingResult) {
        Book bk = bookService.getBook(book.getId());
        bk.setSell(book.getSell());

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            model.addAttribute("pageTitle", "Buy a book");
            model.addAttribute("book", bookService.getBook(bk.getId()));
            return "buy";
        }

        bookService.updateBook(bk);

        model.addAttribute("pageTitle", "Thank You!");
        model.addAttribute("book", bookService.getBook(bk.getId()));

        return "confirmation2";
    }

    @RequestMapping("/ranking")
    public String showSightingForm(Model model,
                                   @RequestParam("id") int bookId) {
        model.addAttribute("pageTitle", "Buy");
        //model.addAttribute("squirrel", squirrelService.getSquirrel(squirrelId));

        Book bk = bookService.getBook(bookId);
        model.addAttribute("book", bk);

        return "buy";
    }

    @RequestMapping("/list")
    public String showSquirrelList(Model model) {
        model.addAttribute("pageTitle", "Pick a Book");
        model.addAttribute("bookList", bookService.getBookList());

        return "book-list";
    }

}
