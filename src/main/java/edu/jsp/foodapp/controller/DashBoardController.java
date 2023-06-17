package edu.jsp.foodapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashBoardController {

	@GetMapping("/display")
	public String display() {
		return "<h1>Welcome to Food App</h1>";
	}

}
