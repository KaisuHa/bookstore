package palvelinohjelmointi.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import palvelinohjelmointi.Bookstore.web.BookController;

@SpringBootTest
class BookstoreApplicationTests {
	
	@Autowired
	BookController bookController;
	@Autowired
	//CategoryController categoryController;
	

	@Test
	void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();
		//assertThat(categoryController).isNotNull();

	}

}
