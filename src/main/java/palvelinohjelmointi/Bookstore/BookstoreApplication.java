package palvelinohjelmointi.Bookstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import palvelinohjelmointi.Bookstore.domain.BookRepository;
import palvelinohjelmointi.Bookstore.domain.Book;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookstoreDemo(BookRepository repository) {
		return (args) -> {
			log.info("Save books");
			repository.save(new Book("A Farewell To Arms","Ernest Heminway", "1929","123456-456", "159,90"));
			repository.save(new Book("Animal Farm","George Ormwell", "1989","175356-416", "189,90"));	
			
			log.info("Get all books");
			for (Book book:repository.findAll()) {
				log.info(book.toString());
			}

		};
		
	}
}
