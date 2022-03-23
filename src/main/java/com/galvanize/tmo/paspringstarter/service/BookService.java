package com.galvanize.tmo.paspringstarter.service;

import com.galvanize.tmo.paspringstarter.data.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Map<String, List<Book>> getBooks() {
        // get all rooms
        Iterable<Book> books = this.bookRepository.findAll();
        List<Book> bookList = new ArrayList<>();

        for (Book book : books) {
            bookList.add(book);
        }

        return new HashMap<String, List<Book>>()
        {{
            put("books", bookList);
        }};
    }

    public Book addBook(Book book) {
        try {
            bookRepository.save(book);
            return book;
//            System.out.println(book);
//            return null;
        }catch(Exception e ){
            System.out.println(e.toString());
            return null;
        }
    }

    public void deleteBooks() {
        try{
            this.bookRepository.deleteAll();
        }catch(Exception e ){
            System.out.println(e.toString());
        }
    }
}
