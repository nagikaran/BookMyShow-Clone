package edu.bookmyshow.project.serviceinterface;

import org.springframework.http.ResponseEntity;

import edu.bookmyshow.project.dto.CustomerDto;
import edu.bookmyshow.project.entity.Customer;

public interface CustomerServiceInterface {

	public CustomerDto saveCustomerDetails(Customer customer);

	public ResponseEntity<CustomerDto> getCustomerDetailsAsperId(long customerId);

	public CustomerDto updateDetailsOfTheCustomerAsPerId(long customerId, Customer customer);

}
