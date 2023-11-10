package com.ecom.util;

import org.springframework.beans.BeanUtils;

import com.ecom.dto.CustomerDto;
import com.ecom.dto.EmployeeDto;
import com.ecom.dto.OrderDetailDto;
import com.ecom.dto.OrderDto;
import com.ecom.pojo.Customer;
import com.ecom.pojo.Employee;
import com.ecom.pojo.Order;
import com.ecom.pojo.OrderDetail;

/**
 * Class used to map relevant attributes of a entity to its corresponding dtos
 * 
 * @author pratay.roy
 */
public class Mapper {
	/**
	 * Method to map order to its dto
	 * 
	 * @param order
	 * @return orderDto
	 */
	public static OrderDto orderDtoMpper(Order order) {
		OrderDto orderDto = new OrderDto();
		try {
			orderDto.initialize();
			BeanUtils.copyProperties(order.getCustomer(), orderDto.getCustomer());
			BeanUtils.copyProperties(order.getEmployee(), orderDto.getEmployee());
			BeanUtils.copyProperties(order.getShipper(), orderDto.getShipper());
			BeanUtils.copyProperties(order, orderDto);
		} catch (Exception e) {
			e.printStackTrace();
			return orderDto;
		}
		return orderDto;
	}

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

	/**
	 * Method to map employee to its dto
	 * 
	 * @param employee
	 * @return employeeDto
	 */
	public static EmployeeDto employeeDtoMapper(Employee employee) {
		EmployeeDto employeeDto = new EmployeeDto();
		try {
			BeanUtils.copyProperties(employee, employeeDto);
		} catch (Exception e) {
			e.printStackTrace();
			return employeeDto;
		}
		return employeeDto;
	}

	/**
	 * Method to map orderDetail to its dto
	 * 
	 * @param orderDetail
	 * @return orderDetailDto
	 */
	public static OrderDetailDto orderDetailDtoMapper(OrderDetail orderDetail) {
		OrderDetailDto orderDetailDto = new OrderDetailDto();
		try {
			orderDetailDto.initialize();
			BeanUtils.copyProperties(orderDetailDto.getOrder(), orderDetailDto.getOrder());
			BeanUtils.copyProperties(orderDetailDto.getProduct(), orderDetailDto.getProduct());
			BeanUtils.copyProperties(orderDetailDto, orderDetailDto);
		} catch (Exception e) {
			e.printStackTrace();
			return orderDetailDto;
		}
		return orderDetailDto;
	}
}
