package rideshare.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import rideshare.domain.User;

public interface UserService extends UserDetailsService {

	UserDetails loadUserByUsername(String username);
	User loadUserById(Long id);
	User loadUser(String username);
	void addRegularUser(String username, String password, String email,
	String answer, String firstname, String lastname);
	boolean isAnswerValid(String username, String answer);
	boolean validateCredentials(String username, String password);
	void logout();
	boolean validateCurrentPassword(String password);
	void updatePasswordById(String password);
	void updateAnswerById(String answer);
	void updatePasswordByUsername(String username, String password);
	void updateUser(String username, String firstname, String lastname, String email);
	boolean doesUserExist(String username);
	List<User> getPublicUsers();
}