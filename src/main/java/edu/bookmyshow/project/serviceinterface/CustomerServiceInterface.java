package edu.bookmyshow.project.serviceinterface;

import edu.bookmyshow.project.dto.CustomerDto;
import edu.bookmyshow.project.entity.Customer;

public interface CustomerServiceInterface {

	public CustomerDto saveCustomerDetails(Customer customer);

}
