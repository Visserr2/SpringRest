package nl.thuis.tutorial.rest.dao;

import java.util.List;

import nl.thuis.tutorial.rest.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
