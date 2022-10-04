package palvelinohjelmointi.Bookstore;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import palvelinohjelmointi.Bookstore.domain.Book;
import palvelinohjelmointi.Bookstore.domain.BookRepository;
import palvelinohjelmointi.Bookstore.domain.Category;

@DataJpaTest
class RepositoryTests {

	@Autowired
	BookRepository bookRepository;
	
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void findByAuthor() {
		
		//Book book = bookRepository.findById((long) 2).get().getBook();
		//System.out.println("Haetaan id:lla 2 " + book);
		//assertEquals(book.getAuthor(), "Ernest Hemingway");
		
		List<Book> books = bookRepository.findByAuthor("Ernest Hemingway");
		assertEquals(books.size(), 1);
	}
	@Test
	public void insertNewBook() {
		Book book = new Book("Häräntappoase", "Anna-Leena Härkönen", "1984", "123546-7456", "140,00", new Category("Novel"));
		bookRepository.save(book);
		assertNotNull(book.getId());
	}

}
