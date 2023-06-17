package edu.jsp.foodapp.execption;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class UserIsNotValiedToAddItem extends RuntimeException {

	private String message;

	@Override
	public String getMessage() {
		return message;
	}

}
