package org.ms.springdemo.controller;

import java.util.List;

import org.ms.springdemo.entity.Customer;
import org.ms.springdemo.rest.CustomerNotFoundException;
import org.ms.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer theCustomer = customerService.getCustomer(customerId);
		if (theCustomer==null) {
			throw new CustomerNotFoundException("Costomer id not found..." + customerId);
		}
		return theCustomer;
	}
	
	@PostMapping("/customers") 
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		theCustomer.setId(0); //force to insert new customer
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	@PutMapping("/customers") 
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		Customer theCustomer = customerService.getCustomer(customerId);
		if (theCustomer==null) {
			throw new CustomerNotFoundException("Costomer id not found..." + customerId);
		}
		customerService.deleteCustomer(customerId);
		return "Deleted customer id - " + customerId;
	}
	
	
	
}
