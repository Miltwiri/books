package com.mutwiri.books.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import static com.mutwiri.books.TestData.testBook;
import static com.mutwiri.books.TestData.tesBookEntity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import com.mutwiri.books.domain.Book;
import com.mutwiri.books.domain.BookEntity;
import com.mutwiri.books.repositories.BookRepository;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl underTest;

    @Test
    public void testThatBookIsSaved() {
        final Book book = testBook();

        final BookEntity bookEntity = tesBookEntity();

           when(bookRepository.save(eq(bookEntity))).thenReturn(bookEntity);

            final Book result = underTest.create(book);
            assertEquals(book, result);
    }

}
