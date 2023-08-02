package edu.bookmyshow.project.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import edu.bookmyshow.project.constants.ErrorMessages;
import edu.bookmyshow.project.entity.Customer;
import edu.bookmyshow.project.exception.APIException;
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

	public Customer getCustomerDetailsAsPerId(long customerId) {
		// TODO Auto-generated method stub
		Optional<Customer> findById = customerRepository.findById(customerId);
		if(findById!=null) {
			Customer customer = findById.get();
			return customer;
		}
		return null;
		
		
	}

	public Customer updateCustomerDetailsAsPerId(long customerId, Customer customer) {
		// TODO Auto-generated method stub
		if(customerId!=0) {
			Optional<Customer> findById = customerRepository.findById(customerId);
			
			Customer customerDetailsAsPerIdFromDb = findById.orElseThrow(()-> new APIException(ErrorMessages.NO_DATA_FOUND_FOR_THESE_ID,HttpStatus.BAD_REQUEST));
			customerDetailsAsPerIdFromDb.setCustomerName(customer.getCustomerName());
			customerDetailsAsPerIdFromDb.setCustomerEmail(customer.getCustomerEmail());
			customerDetailsAsPerIdFromDb.setCustomerPassword(customer.getCustomerPassword());
			customerDetailsAsPerIdFromDb.setCustomrPhoneNumber(customer.getCustomrPhoneNumber());
			Customer save = customerRepository.save(customerDetailsAsPerIdFromDb);
			
			return save;
		}
		else {
			throw new APIException(ErrorMessages.PLEASE_PROVIDE_VALID_CUSTOMER_ID,HttpStatus.BAD_REQUEST);
		}
	
		
	}

	public void deleteCustomerAsPerId(long customerId) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(customerId);
		
	}
	
	

}
