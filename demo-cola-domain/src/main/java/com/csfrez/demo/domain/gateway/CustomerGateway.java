package com.csfrez.demo.domain.gateway;

import com.csfrez.demo.domain.customer.Customer;

public interface CustomerGateway {
	
    public Customer getById(String customerId);
    
}
