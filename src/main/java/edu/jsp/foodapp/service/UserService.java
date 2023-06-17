package edu.jsp.foodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.jsp.foodapp.config.ResponseStructure;
import edu.jsp.foodapp.dao.UserDao;
import edu.jsp.foodapp.dto.UserDto;
import edu.jsp.foodapp.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<UserDto>> saveUser(User user) {
		ResponseStructure<UserDto> responseStructure = new ResponseStructure<>();
		responseStructure.setData(mapUserEntityToUserDto(userDao.saveUser(user)));
		responseStructure.setMessage("Saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());

		ResponseEntity<ResponseStructure<UserDto>> responseEntity = new ResponseEntity<>(responseStructure,
				HttpStatus.CREATED);

		return responseEntity;
	}

	private UserDto mapUserEntityToUserDto(User user) {
		return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getPhoneNumber(), user.getRole());
	}

	public ResponseEntity<ResponseStructure<UserDto>> findUserByEmailAndPassword(String email, String password) {
		ResponseStructure<UserDto> responseStructure = new ResponseStructure<>();
		responseStructure.setData(mapUserEntityToUserDto(userDao.findUserByEmailAndPassword(email, password)));
		responseStructure.setMessage("Found");
		responseStructure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

}
