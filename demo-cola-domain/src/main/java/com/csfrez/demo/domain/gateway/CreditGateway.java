package com.csfrez.demo.domain.gateway;

import com.csfrez.demo.domain.customer.Credit;

//Assume that the credit info is in antoher distributed Service
public interface CreditGateway {
    public Credit getCredit(String customerId);
}
