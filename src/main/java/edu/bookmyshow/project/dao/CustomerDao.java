package edu.bookmyshow.project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.bookmyshow.project.entity.Customer;
import edu.bookmyshow.project.repository.CustomerRepository;
@Repository
public class CustomerDao {
	
	@Autowired
	CustomerRepository customerRepository;

	public Customer saveTheCustomerDetails(Customer customer) {
		// TODO Auto-generated method stub
		Customer customerDetails = customerRepository.save(customer);
		return customerDetails;
		
	}

}
