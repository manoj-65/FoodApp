package edu.jsp.foodapp.repostory;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.foodapp.entity.FoodProduct;

public interface FoodProductRepository extends JpaRepository<FoodProduct, Long> {

}
