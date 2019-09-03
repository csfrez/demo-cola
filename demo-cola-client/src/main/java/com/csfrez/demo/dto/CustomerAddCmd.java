package com.csfrez.demo.dto;

import com.alibaba.cola.dto.Command;
import com.csfrez.demo.dto.domainmodel.Customer;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CustomerAddCmd extends Command{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Customer customer;

}
