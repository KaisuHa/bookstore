package palvelinohjelmointi.Bookstore.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import palvelinohjelmointi.Bookstore.domain.BookUser;
import palvelinohjelmointi.Bookstore.domain.BookUserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	
	
	private final BookUserRepository repository;
	
	@Autowired
	public UserDetailServiceImpl(BookUserRepository bookUserRepository) {
	this.repository = bookUserRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	BookUser curruser = repository.findByUsername(username);
	UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(),
	AuthorityUtils.createAuthorityList(curruser.getRole()));
	
	return user;
	}

}
