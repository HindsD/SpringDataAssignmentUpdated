package edu.wctc.springdataassignmentupdated.service;

import edu.wctc.springdataassignmentupdated.entity.Book;

import java.util.List;

public interface BookService {
    Book getBook(int squirrelId);
    void updateBook(Book squirrel);

    List<Book> getBookList();
}
