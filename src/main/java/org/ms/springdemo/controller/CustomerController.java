package org.ms.springdemo.controller;

import java.util.List;

import org.ms.springdemo.entity.Customer;
import org.ms.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomer() {
		System.out.println(customerService.getCustomers());
		return customerService.getCustomers();
	}
}
