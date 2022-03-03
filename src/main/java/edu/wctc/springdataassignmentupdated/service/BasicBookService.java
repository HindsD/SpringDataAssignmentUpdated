package edu.wctc.springdataassignmentupdated.service;

import edu.wctc.springdataassignmentupdated.entity.Book;
import edu.wctc.springdataassignmentupdated.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BasicBookService implements BookService {
    private BookRepository bookRepository;

    @Autowired
    public BasicBookService(BookRepository br) {
        this.bookRepository = br;
    }

    @Override
    public Book getBook(int bookId) {
        Book book;
        Optional<Book> b = bookRepository.findById(bookId);
        if (b.isPresent()) {
            return b.get();
        }
        else  {
            book = new Book();
            book.setId(bookId);
        }
        return book;
    }

    @Override
    public void updateBook(Book book) {
        book.setInventory(book.getInventory() - book.getSell());
        bookRepository.save(book);
    }

    @Override
    public List<Book> getBookList() {
        List<Book> list = new ArrayList<>();
        bookRepository.findAll().forEach(list::add);
        return list;
    }
}
