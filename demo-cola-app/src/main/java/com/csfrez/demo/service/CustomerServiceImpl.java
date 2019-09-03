package com.csfrez.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.cola.command.CommandBusI;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.event.EventBusI;
import com.csfrez.demo.api.CustomerServiceI;
import com.csfrez.demo.dto.CustomerAddCmd;
import com.csfrez.demo.dto.CustomerListByNameQry;
import com.csfrez.demo.dto.domainevent.CustomerCreatedEvent;
import com.csfrez.demo.dto.domainmodel.Customer;
import com.csfrez.demo.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerServiceI {

    @Autowired
    private CommandBusI commandBus;
    
    @Autowired
    private EventBusI eventBus;
    
    @Autowired
	private CustomerRepository customerRepository;

    @Override
    public Response addCustomer(CustomerAddCmd customerAddCmd) {
        return (Response)commandBus.send(customerAddCmd);
    }

	@Override
	@SuppressWarnings("unchecked")
    public MultiResponse<Customer> listByName(CustomerListByNameQry customerListByNameQry) {
        return (MultiResponse<Customer>)commandBus.send(customerListByNameQry);
    }

	@Override
	public Response fire(CustomerCreatedEvent customerCreatedEvent) {
		return eventBus.fire(customerCreatedEvent);
	}

	@Override
	public SingleResponse<Customer> getCustomer(String customerId) {
		return SingleResponse.of(customerRepository.getById(customerId));
	}

}
