package edu.jsp.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.jsp.foodapp.entity.Item;
import edu.jsp.foodapp.execption.ItemWithIdNotFound;
import edu.jsp.foodapp.repostory.ItemRespostory;

@Repository
public class ItemDao {
	@Autowired
	private ItemRespostory itemRespostory;

	public Item saveItem(Item item) {
		return itemRespostory.save(item);
	}

	public Item findItemById(long itemId) {
		Optional<Item> optionalItem = itemRespostory.findById(itemId);
		if (optionalItem.isPresent()) {
			return optionalItem.get();
		}
		throw new ItemWithIdNotFound("Item with the given Id Not Found");
	}

	public List<Item> findAllItem() {
		return itemRespostory.findAll();
	}

	public void removeItemById(long itemId) {
		itemRespostory.delete(findItemById(itemId));
	}

}
