package com.qd.library.management.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qd.library.management.system.entity.Book;
import com.qd.library.management.system.entity.Department;
import com.qd.library.management.system.repository.BookRepository;
import com.qd.library.management.system.repository.DepartmentRepository;

@Service
public class LibraryService {
	
	
//	@Autowired
//    private BookRepository bookRepository;
//
//    @Autowired
//    private DepartmentRepository departmentRepository;
//
//    public Book addBook(Book book, String departmentName) {
//        Department department = departmentRepository.findByName(departmentName);
//        if (department == null) {
//            department = new Department();
//            department.setName(departmentName);
//            departmentRepository.save(department);
//        }
//        book.setDepartment(department);
//        return bookRepository.save(book);
//    }
//
//    public void removeBook(String isbn) {
//        Book book = bookRepository.findByIsbn(isbn);
//        if (book != null) {
//            bookRepository.delete(book);
//        }
//    }
//
//    public List<Book> findBookByTitle(String title) {
//        return bookRepository.findByTitleContainingIgnoreCase(title);
//    }
//
//    public List<Book> findBookByAuthor(String author) {
//        return bookRepository.findByAuthorContainingIgnoreCase(author);
//    }
//
//    public List<Book> listAllBooks() {
//        return bookRepository.findAll();
//    }
//
//    public List<Book> listAvailableBooks() {
//        return bookRepository.findAll().stream()
//                .filter(Book::isAvailability)
//                .toList();
//    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Autowired
    private BookRepository bookRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Book addBook(Book book, String departmentName) {
        if (book.getIsbn() == null) {
            throw new IllegalArgumentException("ISBN cannot be null.");
        }

        if (bookRepository.findByIsbn(book.getIsbn()) != null) {
            throw new IllegalArgumentException("A book with this ISBN already exists.");
        }

        Department department = departmentRepository.findByName(departmentName);
        if (department == null) {
            department = new Department();
            department.setName(departmentName);
            departmentRepository.save(department);
        }
        book.setDepartment(department);
        return bookRepository.save(book);
    }

    public void removeBook(String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book != null) {
            bookRepository.delete(book);
        }
    }

    public List<Book> findBookByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Book> findBookByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }

    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> listAvailableBooks() {
        return bookRepository.findAll().stream()
                .filter(Book::isAvailability)
                .toList();
    }

}
