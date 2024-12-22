package com.qd.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qd.library.entity.Book;
import com.qd.library.entity.Department;
import com.qd.library.repository.BookRepository;
import com.qd.library.repository.DepartmentRepository;

@Service
public class LibraryService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired 
	private DepartmentRepository departmentRepository;
	
	public Book  addBook(Book book,String departmentName) {
		
		if(book.getIsbn()==null) {
			throw new IllegalArgumentException("ISBN cannot be null");
		}
		
		if(bookRepository.findByIsbn(book.getIsbn())!=null) {
			throw new IllegalArgumentException("this ISBN already exists");
		}
		
	//	Department department=departmentRepository.findByName(departmentName);
		Optional<Department> department=departmentRepository.findByName(departmentName);

		Department department1=null;
		if(department.isEmpty()) { 
			//department1=department.get();
			department1=new Department();
			department1.setName(departmentName);
			
			departmentRepository.save(department1);
			
		}
		book.setDepartment(department1);
		return bookRepository.save(book);
	}
	
	
	
	public void removeBook(String isbn) {
		Book book=bookRepository.findByIsbn(isbn);
		if(book!=null) {
			bookRepository.delete(book);

		}
	}
	
	public List<Book> findBookByTitle(String title){
		return bookRepository.findByTitleContainingIgnoreCase(title);
		
	}
	
	public List<Book> findBookByAuthor(String author){
		return bookRepository.findByAuthorContainingIgnoreCase(author);
	}
	
	public List<Book> listAllBooks(){
		return bookRepository.findAll();
	}
	 
	
	public List<Book> listAvailableBooks(){
		return  bookRepository.findAll().stream()
				.filter(Book::isAvailability).toList();
	}

}
