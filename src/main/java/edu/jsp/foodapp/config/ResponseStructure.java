package edu.jsp.foodapp.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ResponseStructure<T> {
	private int status;
	private String message;
	private T data;
}
