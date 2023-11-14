package com.mutwiri.books.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutwiri.books.domain.Book;
import com.mutwiri.books.domain.BookEntity;
import com.mutwiri.books.repositories.BookRepository;
import com.mutwiri.books.services.BookService;

@Service
/*
 * puts the BookService Implementation class into the spring context so any time
 * BookService is needed, the BSImpl class is injected
 */
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    /*
     * above is an instance variable to Book Service Impl..made final so that: a.
     * good practice
     * b. cannot be reassigned once class is constructed
     */
    @Autowired
    public BookServiceImpl(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /*
     * above is the constructor that requires bookRepo ans assigns it to the
     * instance variable bookRepo
     */
    @Override
    /*The create method below takes the book and converts it to BookEntity and save the entity  using the bookREpo and return the bookEntity converted to a book*/
    public Book create(final Book book) {
        final BookEntity bookEntity = bookToBookEntity(book);
        final BookEntity savedBookEntity = bookRepository.save(bookEntity);
        return bookEntityToBook(savedBookEntity);
    }

    private BookEntity bookToBookEntity(Book book){
        return BookEntity.builder()
        .isbn(book.getIsbn())
        .title(book.getTitle())
        .author(book.getAuthor())
        .build();
    }
     private Book bookEntityToBook(BookEntity bookEntity){
        return Book.builder()
        .isbn(bookEntity.getIsbn())
        .title(bookEntity.getTitle())
        .author(bookEntity.getAuthor())
        .build();
    }

}
