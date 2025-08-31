package com.example.avsk.lms.controller;

import com.example.avsk.lms.model.Author;
import com.example.avsk.lms.model.Book;
import com.example.avsk.lms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id){
        Book book = bookService.getBookById(id);
        if(book == null){
            return ResponseEntity.notFound().build();
        }
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id){
        Book book = bookService.getBookById(id);
        if(book == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book){
        Book existingBook = bookService.getBookById(id);
        if(existingBook == null){
            return ResponseEntity.notFound().build();
        }
        book.setId(id);
        bookService.saveOrUpdateBook(book);
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        Book createdBook = bookService.saveOrUpdateBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

}

