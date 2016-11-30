package rideshare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rideshare.domain.User;
import rideshare.security.RideShareUserDetails;
import rideshare.security.SecurityUtils;

@Service
@Qualifier("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository accountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private SecurityUtils security;

	/*
	 * Inserts a new user
	 */
	public void addRegularUser(String username, String password, String email, String answer, String firstname,
			String lastname) {
		User user = new User();
		user.addAccountInfo(username, password, email, answer, firstname, lastname);
		user.setPassword(passwordEncoder.encode(password));
		accountRepository.save(user);
	}

	public boolean validateCredentials(String username, String password) {
		User user = accountRepository.getUserModelByUsername(username);
		return passwordEncoder.matches(password, user.getPassword());
	}

	@Transactional
	public void logout() {
		// TODO: purge from redis...for now, who cares, tokens live forever!!
	}

	public boolean validateCurrentPassword(String password) {
		return (accountRepository.findUserByIdAndPassword(security.getCurrentUserId(), passwordEncoder.encode(password)) != null);
	}

	@Transactional
	public void updatePasswordById(String password) {
		accountRepository.updatePasswordById(passwordEncoder.encode(password), security.getCurrentUserId());
	}

	public boolean doesUserExist(String username) {
		return accountRepository.findByUsername(username) != null;
	}

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = accountRepository.getUserModelByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Unable to locate account for user: "+ username);
		}
		return new RideShareUserDetails(user);
	}

	@Transactional
	public User loadUserById(Long id) {
		return accountRepository.findById(id);
	}

	@Transactional
	public User loadUser(String username) {
		return accountRepository.getUserModelByUsername(username);
	}

	@Transactional
	public void updateUser(String username, String firstname, String lastname, String email) {
		accountRepository.updateUserProfile(username, firstname, lastname, email);
	}

	public List<User> getPublicUsers() {
		return accountRepository.getUsersByPrivacyDisabled();
	}

	public boolean isAnswerValid(String username, String answer) {
		if (accountRepository.getAnswerByUsername(username).equals(answer))
			return true;
		else
			return false;
	}

	@Transactional
	public void updatePasswordByUsername(String username, String password) {
		accountRepository.updatePasswordByUsername(username, passwordEncoder.encode(password));
	}

	public void updateAnswerById(String answer) {
		accountRepository.updateAnswerById(answer, security.getCurrentUserId());
	}
}