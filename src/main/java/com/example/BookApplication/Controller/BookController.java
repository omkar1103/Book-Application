package com.example.BookApplication.Controller;

import com.example.BookApplication.Entity.Book;
import com.example.BookApplication.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("book/V1")
public class BookController {

    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
       Book savbook= bookService.addBook(book);
       return ResponseEntity.ok(savbook);

    }
    @GetMapping("/getBook/{name}")
    public ResponseEntity<Book> getBookbyID(@PathVariable String name){
        final Book bookByname= bookService.getbookByname(name);
        return ResponseEntity.ok(bookByname);
    }

    @PutMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        Book updatebook = bookService.updateBook(book);
        return ResponseEntity.ok(updatebook);
    }

    @DeleteMapping("/getBook/{id}")
    public ResponseEntity<Book> deleteBookbyID(@PathVariable("id") Integer id){
       bookService.deletebook(id);
       return ResponseEntity.ok().build();
    }
}
