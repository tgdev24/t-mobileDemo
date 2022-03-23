package com.galvanize.tmo.paspringstarter.service;

import com.galvanize.tmo.paspringstarter.data.*;
import org.springframework.stereotype.Service;

import java.util.*;

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

        bookList.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });

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
