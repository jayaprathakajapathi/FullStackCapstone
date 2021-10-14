package com.capstone.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.entity.Foodbox;
import com.capstone.service.FoodboxService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FoodboxController {

	@Autowired
	FoodboxService foodboxService;

	@GetMapping("/items")
	private List getAllFoodbox() {
		return foodboxService.getAllItems();
	}

	@GetMapping("/items/{id}")
	private Foodbox getitem(@PathVariable("id") int item_no) {
		return foodboxService.getfoodboxById(item_no);
	}
	@DeleteMapping("/items/{id}")
	private void delete(@PathVariable("id") int id) {
		foodboxService.deleteItem(id);
	}

	@PostMapping("/items")
	private int saveFoodbox(@RequestBody Foodbox foodbox) {
		foodboxService.saveOrUpdate(foodbox);
		return foodbox.getItem_no();
	}
}