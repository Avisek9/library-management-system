package com.example.avsk.lms.service;

import com.example.avsk.lms.model.Author;
import com.example.avsk.lms.model.Book;
import com.example.avsk.lms.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public Book getBookById(int id){
        return bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Given Id is incorrect"));
    }

    public Book saveOrUpdateBook(Book book){
        return bookRepo.save(book);
    }

    public void deleteBookById(int id){
        bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Given Id is incorrect"));
        bookRepo.deleteById(id);
    }
}


