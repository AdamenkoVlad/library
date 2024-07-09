package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class BookController {
 private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Book> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(bookService.findById(id));
    }

    @PostMapping("/book")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
            Book result = bookService.save(book);
            return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @PostMapping("/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Book> update(@PathVariable Long id,@RequestBody Book book){
            return ResponseEntity.ok().body(bookService.save(book));
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        bookService.deleteById(id);
        return ResponseEntity.ok("Book deleted successfully");
    }

}
