package com.csfrez.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.csfrez.demo.domain.customer.Customer;
import com.csfrez.demo.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	//com.csfrez.demo.test.CustomerRepositoryTest.getByIdTest()
	@Test
    public void getByIdTest() {
		try {
			Customer customer = customerRepository.getById("1000");
			System.out.println(JSON.toJSONString(customer));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
