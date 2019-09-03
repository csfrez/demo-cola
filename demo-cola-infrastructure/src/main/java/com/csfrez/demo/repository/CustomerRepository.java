package com.csfrez.demo.repository;

import com.alibaba.fastjson.JSON;
import com.csfrez.demo.domain.customer.Customer;
import com.csfrez.demo.domain.gateway.CustomerGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerRepository implements CustomerGateway {
    
	@Autowired
    private CustomerMapper customerMapper;

	@Override
    public Customer getById(String customerId){
      CustomerDO customerDO = customerMapper.getById(customerId);
      //Convert to Customer
      return JSON.parseObject(JSON.toJSONString(customerDO), Customer.class);
    }
}
