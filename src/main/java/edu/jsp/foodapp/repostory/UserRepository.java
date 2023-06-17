package edu.jsp.foodapp.repostory;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.foodapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	/*
	 * @Query("SELECT u User WHERE u.email=?1 AND u.password=?2") // SELECT u FROM
	 * User u WHERE u.email = :email AND u.password = :password Optional<User>
	 * getUserBYEmailAndPassword(String email, String password);
	 */

	// This Method creates the Query By itself
	User findUserByEmailAndPassword(String email, String password);

}
