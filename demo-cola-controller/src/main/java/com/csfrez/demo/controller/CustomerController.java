package com.csfrez.demo.controller;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.csfrez.demo.api.CustomerServiceI;
import com.csfrez.demo.dto.CustomerAddCmd;
import com.csfrez.demo.dto.CustomerListByNameQry;
import com.csfrez.demo.dto.domainmodel.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerServiceI customerService;

    @GetMapping(value = "/customer")
    public MultiResponse<Customer> listCustomerByName(@RequestParam String name){
        CustomerListByNameQry customerListByNameQry = new CustomerListByNameQry();
        customerListByNameQry.setName(name);
        return customerService.listByName(customerListByNameQry);
    }

    @PostMapping(value = "/customer")
    public Response addCustomer(@RequestBody CustomerAddCmd customerAddCmd){
        return customerService.addCustomer(customerAddCmd);
    }
    
    @GetMapping(value = "/customer/{customerId}")
    public SingleResponse<Customer> getCustomer(@PathVariable String customerId){
        return customerService.getCustomer(customerId);
    }
}
