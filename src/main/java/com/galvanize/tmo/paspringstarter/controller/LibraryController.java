package com.galvanize.tmo.paspringstarter.controller;

import com.galvanize.tmo.paspringstarter.data.Book;
import com.galvanize.tmo.paspringstarter.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class LibraryController {
    private final BookService bookService;

    public LibraryController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/health")
    public String health() {
        return "it's working";
    }

    @GetMapping("/api/books")
    public Map<String, List<Book>> getBooks() {
        return this.bookService.getBooks();
    }

    @PostMapping(path="/api/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return this.bookService.addBook(book);
    }

    @DeleteMapping(path="/api/books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBooks() {
        this.bookService.deleteBooks();
    }

}
