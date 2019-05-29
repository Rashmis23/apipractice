package com.library.app.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.library.app.dataobjects.Books;
import com.library.app.exception.ResourceConflictException;
import com.library.app.repository.BookRepository;




@RestController
public class BookController {
	private final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping(path = "/allbooks")
	public ResponseEntity<List<Books>> BookList() {
		List<Books> books = this.bookRepository.getAllBooks();
	
		return new ResponseEntity<List<Books>>(books, HttpStatus.OK);
	}
	
	@GetMapping(path = "books/{bookId}")
	public ResponseEntity<Books> bookById(@PathVariable("bookId") String bookId) {
		Books bookById = this.bookRepository.findOne(Long.parseLong(bookId));
		return new ResponseEntity<Books>(bookById, HttpStatus.OK);
	}
	
	
	@PostMapping("/addbook")
	public ResponseEntity<Books> addBook(@RequestBody Books books) throws IOException {
		logger.info("savebook() ..... Start");
	
		books.setStatus('A');
		Books savedBook = this.bookRepository.save(books);
		logger.info("saveBook() ..... End");
		return new ResponseEntity<Books>(savedBook, HttpStatus.OK);
	}
	
	@PutMapping("/updateBook")
	public ResponseEntity<Books> updateBook(@RequestBody Books books) throws IOException {
		logger.info("updatebook() ..... Start");
		Books savedBook = this.bookRepository.save(books);
		logger.info("updateBook() ..... End");
		return new ResponseEntity<Books>(savedBook, HttpStatus.OK);
	}

	@DeleteMapping(path = "deleteBook/{bookId}")
	public ResponseEntity<HttpStatus> deletebook(@PathVariable("bookId") String bookId) {
		Books book = this.bookRepository.findOne(Long.parseLong(bookId));
		book.setStatus('I');
		Books savedBook = this.bookRepository.save(book);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		
	}
	
	
	

}
