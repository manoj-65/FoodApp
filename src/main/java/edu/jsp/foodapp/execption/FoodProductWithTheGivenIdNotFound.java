package edu.jsp.foodapp.execption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodProductWithTheGivenIdNotFound extends RuntimeException {
	private String message;

	@Override
	public String getMessage() {
		return message;
	}

}
