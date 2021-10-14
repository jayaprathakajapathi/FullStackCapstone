package com.capstone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.capstone.entity.Foodbox;

import com.capstone.repository.FoodboxRepository;

@Service
public class FoodboxService {

	@Autowired
	FoodboxRepository foodboxRepository;

	@Autowired
	

	public List getAllItems() {
		List foodboxs = new ArrayList();
		foodboxRepository.findAll().forEach(foodbox -> foodboxs.add(foodbox));
		return foodboxs;
	}

	public Foodbox getfoodboxById(int item_no) {
		return foodboxRepository.findById(item_no).get();
	}
    public void saveOrUpdate(Foodbox foodbox) {
		
		foodboxRepository.save(foodbox);
	}

	 public void deleteItem(int item_no) {
		foodboxRepository.deleteById(item_no);
	}
}

