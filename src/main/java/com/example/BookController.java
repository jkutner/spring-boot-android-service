package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

  private BookRepository repository;

  @Autowired
  public BookController(BookRepository repository) {
    this.repository = repository;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Book> get(@PathVariable("id") Long id) {
    Book book = repository.findOne(id);
    if (null == book) {
      return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Book>(book, HttpStatus.OK);
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public ResponseEntity<Book> update(@RequestBody Book book) {
    repository.save(book);
    return get(book.getId());
  }

  @RequestMapping
  public List<Book> all() {
    return repository.findAll();
  }
}
