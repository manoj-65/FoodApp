package edu.jsp.foodapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.jsp.foodapp.config.ResponseStructure;
import edu.jsp.foodapp.dao.ItemDao;
import edu.jsp.foodapp.dao.UserDao;
import edu.jsp.foodapp.entity.Item;
import edu.jsp.foodapp.entity.Role;
import edu.jsp.foodapp.entity.User;
import edu.jsp.foodapp.execption.UserIsNotValiedToAddItem;

@Service
public class ItemServicve {
	@Autowired
	private UserDao userDao;
	@Autowired
	private ItemDao itemDao;

	public ResponseEntity<ResponseStructure<List<Item>>> saveItems(List<Item> items, long userId) {
		User user = userDao.findUserById(userId);
		if (user.getRole().equals(Role.ADMIN) || user.getRole().equals(Role.MANAGER)) {
			List<Item> listOfItems = new ArrayList<>();
			for (Item item : items) {
				listOfItems.add(itemDao.saveItem(item));
			}
			ResponseStructure<List<Item>> responseStructure = new ResponseStructure<>();
			responseStructure.setData(listOfItems);
			responseStructure.setMessage("Saved!!");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
		}

		throw new UserIsNotValiedToAddItem("User Is Not Have Access to Add the Item");
	}

}
