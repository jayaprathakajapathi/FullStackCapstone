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
import com.capstone.entity.Cartdetail;
import com.capstone.repository.CartdetailRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class CartDetailsApplicationTests {
	@Autowired
	CartdetailRepository cRepo;
	@Test
	@Order(1)
	public void testCreate () {
		Cartdetail c= new Cartdetail();
		c.setId(2);
		c.setCategory_name("indian");
		c.setItem_name("idly");
					cRepo.save(c);
		assertNotNull(cRepo.findById(2).get());
	}
	@Test
	@Order(2)
	public void testReadAll () {
		//List list = cRepo.findAll();
	//assertThat(list).size().isGreaterThan(0);
	}
	@Test
	@Order(3)
	public void testRead () {
		Cartdetail cartdetail = cRepo.findById(3).get();
		assertEquals("idly", cartdetail.getItem_name());
	}
		
	@Test
	@Order(4)
	public void testUpdate () {
		Cartdetail c = cRepo.findById(2).get();
		c.setCategory_name("indian");
		cRepo.save(c);
		assertEquals("indian", cRepo.findById(1).get().getCategory_name());
	}
		
	@Test
	@Order(5)
	public void testDelete () {
		cRepo.deleteById(1);
		assertThat(cRepo.existsById(2)).isFalse();
	}
	
}
