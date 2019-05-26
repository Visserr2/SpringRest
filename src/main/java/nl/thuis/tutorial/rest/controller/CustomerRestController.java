package nl.thuis.tutorial.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.thuis.tutorial.rest.entity.Customer;
import nl.thuis.tutorial.rest.exception.CustomerNotFoundException;
import nl.thuis.tutorial.rest.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
	
	@GetMapping("/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer customer = customerService.getCustomer(customerId);
		if(customer == null) {
			throw new CustomerNotFoundException("There is no customer with the following Id - " + customerId);
		}
		
		return customer;
	}
	
}
