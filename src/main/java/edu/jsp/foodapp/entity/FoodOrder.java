package edu.jsp.foodapp.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class FoodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Status foodStatus;
	@CreationTimestamp
	private LocalDateTime orderCreatedTime;
	private LocalDateTime orderDeliveryTime;
	private double totalPrice;
	@OneToMany
	private List<FoodProduct> products;
}
