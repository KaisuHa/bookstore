package palvelinohjelmointi.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import palvelinohjelmointi.Bookstore.domain.BookRepository;
import palvelinohjelmointi.Bookstore.domain.BookUser;
import palvelinohjelmointi.Bookstore.domain.BookUserRepository;
import palvelinohjelmointi.Bookstore.domain.Category;
import palvelinohjelmointi.Bookstore.domain.CategoryRepository;
import palvelinohjelmointi.Bookstore.domain.Book;
//import palvelinohjelmointi.Bookstore.domain.BookUser;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);	

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookstoreDemo(BookRepository repository, CategoryRepository crepository, BookUserRepository urepository) {
		return (args) -> {
			log.info("Save books");
			crepository.save(new Category ("Horror"));
			crepository.save(new Category ("Romance"));
			crepository.save(new Category ("Western"));
			
			repository.save(new Book("A Farewell To Arms","Ernest Hemingway", "1929","123456-456", "159,90", crepository.findByName("Horror").get(0)));
			repository.save(new Book("Animal Farm","George Ormwell", "1989","175356-416", "189,90", crepository.findByName("Romance").get(0)));	
			
			//create users
			BookUser user1 = new BookUser (null, "Anna","Anttonen", "USER", "user", "$2a$10$PY2HJl2tpcBvSAQRXqbFY.JRIYvw6lNT3IA19V7wEHMW41Ys9WDDi");
			BookUser user2 = new BookUser (null, "Maija","Maijanen", "ADMIN", "admin", "$2a$10$LnafXGUeoHTXKIbQGVgvZeWhsP9s19Wi35Rj/EY.lzD37yr3pHSCy");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("Get all books");
			for (Book book:repository.findAll()) {
				log.info(book.toString());
			}

		};
		
	}
}
