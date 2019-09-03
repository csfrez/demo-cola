package com.csfrez.demo.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.csfrez.demo.dto.CustomerAddCmd;
import com.csfrez.demo.dto.CustomerListByNameQry;
import com.csfrez.demo.dto.domainevent.CustomerCreatedEvent;
import com.csfrez.demo.dto.domainmodel.Customer;

public interface CustomerServiceI {

    public Response addCustomer(CustomerAddCmd customerAddCmd);

    public MultiResponse<Customer> listByName(CustomerListByNameQry customerListByNameQry);
    
    public Response fire(CustomerCreatedEvent customerCreatedEvent);
}
