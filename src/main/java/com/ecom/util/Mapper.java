package com.ecom.util;

import org.springframework.beans.BeanUtils;

import com.ecom.dto.CustomerDto;
import com.ecom.pojo.Customer;

/**
 * Class used to map relevant attributes of a entity to its corresponding dtos
 * 
 * @author pratay.roy
 */
public class Mapper {
	/**
	 * Method to map customer to its dto
	 * 
	 * @param customer
	 * @return customerDto
	 */
	public static CustomerDto customerDtoMapper(Customer customer) {
		CustomerDto customerDto = new CustomerDto();
		try {
			BeanUtils.copyProperties(customer, customerDto);
		} catch (Exception e) {
			e.printStackTrace();
			return customerDto;
		}
		return customerDto;
	}
}
