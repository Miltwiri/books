package com.mutwiri.books;

import com.mutwiri.books.domain.Book;
import com.mutwiri.books.domain.BookEntity;

public final class TestData {
    private TestData(){

    }
    public static Book testBook(){
        return Book.builder()
        .isbn("001")
        .author("mutwiri mwirabua")
        .title("Spring intro")
        .build();
    }
    public static BookEntity tesBookEntity(){
          return BookEntity.builder()
        .isbn("001")
        .author("mutwiri mwirabua")
        .title("Spring intro")
        .build();
    }
    }

