package edu.jsp.foodapp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.jsp.foodapp.entity.User;
import edu.jsp.foodapp.execption.UserEmailAndPasswordNotFound;
import edu.jsp.foodapp.execption.UserIdNotFoundException;
import edu.jsp.foodapp.repostory.UserRepository;

@Repository
public class UserDao {
	@Autowired
	private UserRepository userRespostory;

	public User saveUser(User user) {
		return userRespostory.save(user);
	}

	public User findUserById(long userId) {
		Optional<User> optional = userRespostory.findById(userId);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new UserIdNotFoundException("User With the Given Id Not Found!!");
	}

	public User findUserByEmailAndPassword(String email, String password) {
		User optional = userRespostory.findUserByEmailAndPassword(email, password);
		if (optional != null) {
			return optional;
		}
		throw new UserEmailAndPasswordNotFound("User With the Given Email And Password Not Found!!");
	}

	public void deleteUserById(long userId) {
		userRespostory.delete(findUserById(userId));
	}
}
