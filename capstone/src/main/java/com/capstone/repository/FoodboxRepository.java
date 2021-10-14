package com.capstone.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.capstone.entity.Foodbox;


public interface FoodboxRepository extends CrudRepository<Foodbox, Integer> {

}