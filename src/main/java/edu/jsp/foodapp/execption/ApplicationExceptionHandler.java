package edu.jsp.foodapp.execption;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import edu.jsp.foodapp.config.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserEmailAndPasswordNotFound.class)
	public ResponseEntity<ResponseStructure<String>> handleUserEmailAndPasswordNotFound(
			UserEmailAndPasswordNotFound e) {

		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setData(e.getMessage());
		responseStructure.setMessage("User Info Not Valid");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		List<ObjectError> errors = exception.getAllErrors();
		Map<String, String> errorMessages = new HashMap<>();
		for (ObjectError objectError : errors) {
			String filedName = ((FieldError) objectError).getField();
			String errorMessage = objectError.getDefaultMessage();
			errorMessages.put(filedName, errorMessage);
		}

		ResponseStructure<Map<String, String>> responseStructure = new ResponseStructure<>();
		responseStructure.setData(errorMessages);
		responseStructure.setMessage("Verify The User Info");
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<Object>(responseStructure, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserIsNotValiedToAddItem.class)
	public ResponseEntity<ResponseStructure<String>> handleUserIsNotValiedToAddItem(
			UserIsNotValiedToAddItem exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setData(exception.getMessage());
		responseStructure.setMessage("User Is Not Valid to Add Item");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}

}
