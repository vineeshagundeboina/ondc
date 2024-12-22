package com.qd.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qd.library.entity.Book;
import com.qd.library.service.LibraryService;

@RestController
@RequestMapping("/library")
@CrossOrigin(origins = "*")
public class LibraryController {
	
	@Autowired
	private LibraryService libraryService;
	
	@PostMapping("/addbook")
	public ResponseEntity<Book> addBook(@RequestBody Book book,@RequestParam String departmentName){
		System.out.println("departmentName>>> "+departmentName);
		return ResponseEntity.ok(libraryService.addBook(book, departmentName));
	}
	
	
	@DeleteMapping("/removebook/{isbn}")
	public void removeBook(@PathVariable String isbn) {
		libraryService.removeBook(isbn);
	}
	
	@GetMapping("/findbookbytitle")
	public List<Book> findBookByTitle(@RequestParam String title){
		return libraryService.findBookByTitle(title);
		
	}
	
	@GetMapping("/findbookbyauthor")
	public List<Book> findBookByAuthor(@RequestParam String author){
		return libraryService.findBookByAuthor(author);
				
				
	}
	
	@GetMapping("/listallbooks")
	public List<Book> listAllBooks(){
		return libraryService.listAllBooks();
				
	}

	@GetMapping("/listavailablebooks")
	public List<Book> listAvailableBooks(){
		return libraryService.listAvailableBooks();
	}
}
