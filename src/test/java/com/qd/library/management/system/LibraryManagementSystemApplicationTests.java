package com.qd.library.management.system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.qd.library.management.system.entity.Book;
import com.qd.library.management.system.entity.Department;
import com.qd.library.management.system.repository.BookRepository;
import com.qd.library.management.system.repository.DepartmentRepository;
import com.qd.library.management.system.service.LibraryService;

@SpringBootTest
class LibraryManagementSystemApplicationTests {

	@Test
	void contextLoads() {
	}
    
	
	
	
	@Mock
    private BookRepository bookRepository;

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private LibraryService libraryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addBook() {
        Department department = new Department();
        department.setId(1L);
        department.setName("Science");

        Book book = new Book();
        book.setTitle("Physics");
        book.setAuthor("John Doe");
        book.setIsbn("12345");
        book.setGenre("Science");
        book.setPublicationYear(2020);
        book.setAvailability(true);
        book.setDepartment(department);

        when(departmentRepository.findByName("Science")).thenReturn(department);
        when(bookRepository.save(book)).thenReturn(book);

        Book savedBook = libraryService.addBook(book, "Science");

        assertNotNull(savedBook);
        assertEquals("Physics", savedBook.getTitle());
    }

    @Test
    void addBookNewDepartment() {
        Department department = new Department();
        department.setName("Math");

        Book book = new Book();
        book.setTitle("Algebra");
        book.setAuthor("Jane Doe");
        book.setIsbn("67890");
        book.setGenre("Math");
        book.setPublicationYear(2021);
        book.setAvailability(true);
        book.setDepartment(department);

        when(departmentRepository.findByName("Math")).thenReturn(null);
        when(departmentRepository.save(any(Department.class))).thenReturn(department);
        when(bookRepository.save(book)).thenReturn(book);

        Book savedBook = libraryService.addBook(book, "Math");

        assertNotNull(savedBook);
        assertEquals("Algebra", savedBook.getTitle());
        verify(departmentRepository, times(1)).save(any(Department.class));
    }

    @Test
    void removeBook() {
        Book book = new Book();
        book.setIsbn("12345");

        when(bookRepository.findByIsbn("12345")).thenReturn(book);
        doNothing().when(bookRepository).delete(book);

        libraryService.removeBook("12345");

        verify(bookRepository, times(1)).delete(book);
    }

    @Test
    void removeNonexistentBook() {
        when(bookRepository.findByIsbn("00000")).thenReturn(null);

        libraryService.removeBook("00000");

        verify(bookRepository, times(0)).delete(any(Book.class));
    }

    @Test
    void findBookByTitle() {
        Book book = new Book();
        book.setTitle("Physics");

        when(bookRepository.findByTitleContainingIgnoreCase("Physics")).thenReturn(Arrays.asList(book));

        List<Book> books = libraryService.findBookByTitle("Physics");

        assertNotNull(books);
        assertEquals(1, books.size());
        assertEquals("Physics", books.get(0).getTitle());
    }

    @Test
    void findBookByAuthor() {
        Book book = new Book();
        book.setAuthor("John Doe");

        when(bookRepository.findByAuthorContainingIgnoreCase("John Doe")).thenReturn(Arrays.asList(book));

        List<Book> books = libraryService.findBookByAuthor("John Doe");

        assertNotNull(books);
        assertEquals(1, books.size());
        assertEquals("John Doe", books.get(0).getAuthor());
    }

    @Test
    void listAllBooks() {
        Book book1 = new Book();
        Book book2 = new Book();

        when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));

        List<Book> books = libraryService.listAllBooks();

        assertNotNull(books);
        assertEquals(2, books.size());
    }

    @Test
    void listAvailableBooks() {
        Book book1 = new Book();
        book1.setAvailability(true);
        Book book2 = new Book();
        book2.setAvailability(false);

        when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));

        List<Book> availableBooks = libraryService.listAvailableBooks();

        assertNotNull(availableBooks);
        assertEquals(1, availableBooks.size());
        assertTrue(availableBooks.get(0).isAvailability());
    }

    @Test
    void addBookWithNullISBN() {
        Book book = new Book();
        book.setTitle("Chemistry");
        book.setAuthor("Jane Doe");
        book.setIsbn(null);
        book.setGenre("Science");
        book.setPublicationYear(2022);
        book.setAvailability(true);

        Department department = new Department();
        department.setId(1L);
        department.setName("Science");

        when(departmentRepository.findByName("Science")).thenReturn(department);

        assertThrows(IllegalArgumentException.class, () -> {
            libraryService.addBook(book, "Science");
        });

        verify(bookRepository, times(0)).save(book);
    }

    @Test
    void addBookDuplicateISBN() {
        Book existingBook = new Book();
        existingBook.setIsbn("12345");

        when(bookRepository.findByIsbn("12345")).thenReturn(existingBook);

        Book newBook = new Book();
        newBook.setTitle("Physics");
        newBook.setAuthor("John Doe");
        newBook.setIsbn("12345");
        newBook.setGenre("Science");
        newBook.setPublicationYear(2020);
        newBook.setAvailability(true);

        Department department = new Department();
        department.setName("Science");

        when(departmentRepository.findByName("Science")).thenReturn(department);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            libraryService.addBook(newBook, "Science");
        });

        assertEquals("A book with this ISBN already exists.", exception.getMessage());
        verify(bookRepository, times(0)).save(newBook);
    }
}


