package palvelinohjelmointi.Bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface BookUserRepository extends CrudRepository<BookUser, Long> {
	
	BookUser findByUsername(String username);

}
