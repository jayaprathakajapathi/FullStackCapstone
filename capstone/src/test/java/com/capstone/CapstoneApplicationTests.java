package com.capstone;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import com.capstone.entity.Foodbox;
import com.capstone.repository.FoodboxRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class CapstoneApplicationTests {
	@Autowired
	FoodboxRepository fRepo;
	@Test
	@Order(1)
	public void testCreate () {
		Foodbox f= new 	Foodbox();
		f.setItem_no(2);
		f.setCategory_id(1);
		f.setItem_name("dosa");
		f.setPrice(120.00);
			fRepo.save(f);
		assertNotNull(fRepo.findById(2).get());
	}
	@Test
	@Order(2)
	public void testReadAll () {
		//List list = fRepo.findAll();
		//assertThat(list).size().isGreaterThan(0);
	}
	@Test
	@Order(3)
	public void testRead () {
		Foodbox foodbox = fRepo.findById(2).get();
		assertEquals("dosa", foodbox.getItem_name());
	}
		
	@Test
	@Order(4)
	public void testUpdate () {
		Foodbox f = fRepo.findById(2).get();
		f.setPrice(120.00);
		fRepo.save(f);
		assertNotEquals(700.00, fRepo.findById(2).get().getPrice());
	}
		
	@Test
	@Order(5)
	public void testDelete () {
		fRepo.deleteById(1);
		assertThat(fRepo.existsById(1)).isFalse();
	}
	
}