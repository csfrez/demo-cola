package com.csfrez.demo.dto;

import com.alibaba.cola.dto.Query;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CustomerListByNameQry extends Query{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	
}
