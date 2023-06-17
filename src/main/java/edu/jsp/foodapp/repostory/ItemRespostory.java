package edu.jsp.foodapp.repostory;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.foodapp.entity.Item;

public interface ItemRespostory extends JpaRepository<Item, Long> {

}
