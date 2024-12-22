package com.qd.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qd.library.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {


	public Book findByIsbn(String isbn);
	
	//public List<Book> findByTitle(String title);

	public List<Book> findByAuthorContainingIgnoreCase(String author);

	public List<Book> findByTitleContainingIgnoreCase(String title);
	
}
