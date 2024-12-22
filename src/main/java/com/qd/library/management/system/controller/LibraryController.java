package com.qd.library.management.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qd.library.management.system.entity.Book;
import com.qd.library.management.system.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {

//    @Autowired
//	  @Qualifier("libraryService")
//    private LibraryService libraryService;
	
	
	/* constructor injection with qualifier*/
	
//	private final LibraryService libraryService;
//	
//	public LibraryController(@Qualifier("libraryService") LibraryService libraryService) {
//		this.libraryService=libraryService;
//	}
	
	
	/* setter injection with qualifier */
	
	private LibraryService libraryService;
	
	public void setBookService(@Qualifier("libraryService") LibraryService libraryService) {
		this.libraryService=libraryService; 
	}

	
	
	
	
	
    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book, @RequestParam String departmentName) {
        return libraryService.addBook(book, departmentName);
    }

    @DeleteMapping("/removeBook/{isbn}")
    public void removeBook(@PathVariable("isbn") String isbn) {
        libraryService.removeBook(isbn);
    }

    @GetMapping("/findBookByTitle")
    public List<Book> findBookByTitle(@RequestParam String title) {
        return libraryService.findBookByTitle(title);
    }

    @GetMapping("/findBookByAuthor")
    public List<Book> findBookByAuthor(@RequestParam String author) {
        return libraryService.findBookByAuthor(author);
    }

    @GetMapping("/listAllBooks")
    public List<Book> listAllBooks() {
        return libraryService.listAllBooks();
    }

    @GetMapping("/listAvailableBooks")
    public List<Book> listAvailableBooks() {
        return libraryService.listAvailableBooks();
    }
}
