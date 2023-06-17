package edu.jsp.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.foodapp.config.ResponseStructure;
import edu.jsp.foodapp.entity.Item;
import edu.jsp.foodapp.service.ItemServicve;

@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemServicve itemServicve;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<List<Item>>> saveItems(@RequestBody List<Item> items,
			@RequestParam long userId) {
		return itemServicve.saveItems(items, userId);
	}
}
