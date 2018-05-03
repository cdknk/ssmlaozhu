package ssm.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ssm.dao.UserDao;
import ssm.entity.User;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userDao.findOneByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserDetailsImpl(user);
	}

}

class UserDetailsImpl extends org.springframework.security.core.userdetails.User {
	private User user;

	public UserDetailsImpl(User user) {
		super(user.getUsername(), user.getPassword(), 
				Arrays.asList(new SimpleGrantedAuthority("ROLE_" + user.getRole())));
		this.user = user;
	}

	public User getUser() {
		return user;
	}
	
}
