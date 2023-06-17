package edu.jsp.foodapp.execption;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UserIdNotFoundException extends RuntimeException {
	private String message;

	@Override
	public String getMessage() {
		return message;
	}

}
