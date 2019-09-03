package com.csfrez.demo.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.cola.dto.Response;
import com.csfrez.demo.api.CustomerServiceI;
import com.csfrez.demo.dto.CustomerAddCmd;
import com.csfrez.demo.dto.domainevent.CustomerCreatedEvent;
import com.csfrez.demo.dto.domainmodel.Customer;
import com.csfrez.demo.dto.domainmodel.ErrorCode;

/**
 * This is for integration test.
 *
 * Created by fulan.zjf on 2017/11/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerServiceI customerService;


    @Before
    public void setUp() {

    }

    @Test
    public void testCustomerAddSuccess(){
        //1.prepare
        CustomerAddCmd customerAddCmd = new CustomerAddCmd();
        Customer customer = new Customer();
        customer.setCompanyName("NormalName");
        customerAddCmd.setCustomer(customer);

        //2.execute
        Response response = customerService.addCustomer(customerAddCmd);

        //3.assert
        Assert.assertTrue(response.isSuccess());
    }
    
    //com.csfrez.demo.test.CustomerServiceTest.testCustomerAddCompanyNameConflict()
    @Test
    public void testCustomerAddCompanyNameConflict(){
        //1.prepare
        CustomerAddCmd customerAddCmd = new CustomerAddCmd();
        Customer customer = new Customer();
        customer.setCompanyName("ConflictCompanyName");
        customerAddCmd.setCustomer(customer);

        //2.execute
        Response response = customerService.addCustomer(customerAddCmd);

        //3.assert
        Assert.assertEquals(ErrorCode.B_CUSTOMER_companyNameConflict.getErrCode(), response.getErrCode());

    }
    
    //com.csfrez.demo.test.CustomerServiceTest.testCustomerCreatedEvent()
    @Test
    public void testCustomerCreatedEvent() {
    	 //1.prepare
    	CustomerCreatedEvent customerCreatedEvent = new CustomerCreatedEvent();
    	customerCreatedEvent.setCustomerId("1000");

        //2.execute
        Response response = customerService.fire(customerCreatedEvent);
        
        //3.assert
        Assert.assertTrue(response.isSuccess());
    	
    }
}
