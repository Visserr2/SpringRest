package nl.thuis.tutorial.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<List<Customer>> getCustomers() {
		return new ResponseEntity<List<Customer>>(customerService.getCustomers(), HttpStatus.OK);
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int customerId) {
		Customer customer = customerService.getCustomer(customerId);
		if(customer == null) {
			throw new CustomerNotFoundException("There is no customer with the following Id - " + customerId);
		}
		
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Integer> createCustomer(@RequestBody Customer customer) {
		// Set to null or zero to save customer instead of update
		customer.setId(0);
		customerService.saveCustomer(customer);
		return new ResponseEntity<Integer>(customer.getId(), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable int customerId) {
		Customer customer = customerService.getCustomer(customerId);
		if(customer == null) {
			throw new CustomerNotFoundException("There is no customer with the following Id - " + customerId);
		}		
		customerService.deleteCustomer(customerId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
