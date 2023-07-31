package edu.bookmyshow.project.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bookmyshow.project.dao.CustomerDao;
import edu.bookmyshow.project.dto.CustomerDto;
import edu.bookmyshow.project.entity.Customer;
import edu.bookmyshow.project.serviceinterface.CustomerServiceInterface;

@Service
public class CustomerService implements CustomerServiceInterface {

	@Autowired
	CustomerDao customerDao;
	@Autowired
	CustomerDto customerDto;
	
	@Override
	public CustomerDto saveCustomerDetails(Customer customer) {
		// TODO Auto-generated method stub
		Customer saveTheCustomerDetails = customerDao.saveTheCustomerDetails(customer);
		customerDto.setCustomerId(saveTheCustomerDetails.getCustomerId());
		CustomerDto entityToCustomerClassDto = entityToCustomerClassDto(saveTheCustomerDetails);
		customerDto.setCustomerName(saveTheCustomerDetails.getCustomerName());
		customerDto.setCustomerEmail(saveTheCustomerDetails.getCustomerEmail());
		customerDto.setCustomrPhoneNumber(saveTheCustomerDetails.getCustomrPhoneNumber());
		return entityToCustomerClassDto;
	}
	
	/*now we are going to change the object as per the requiremnet
	 * like from entity to dto and dto to entity
	 * */
	private Customer dtoToCustomerClass(CustomerDto dto) {
		ModelMapper mm = new ModelMapper();
		return mm.map(dto, Customer.class);
	}

	private CustomerDto entityToCustomerClassDto(Customer entity) {
		ModelMapper mm = new ModelMapper();
		return mm.map(entity, CustomerDto.class);
	}
	

}
