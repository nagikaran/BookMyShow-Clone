package edu.bookmyshow.project.services;


import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.bookmyshow.project.constants.ErrorMessages;
import edu.bookmyshow.project.constants.SuccessMessages;
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
	
	

	@Override
	public ResponseEntity<CustomerDto> getCustomerDetailsAsperId(long customerId) {
		// TODO Auto-generated method stub
	    Logger logger = LoggerFactory.getLogger(this.getClass());
	    logger.info("getCustomerDetailsAsperId - customerId: {}", customerId);

	    Customer customerDetailsAsPerId = customerDao.getCustomerDetailsAsPerId(customerId);
	    if (customerDetailsAsPerId != null) {
	        CustomerDto customerDto = new CustomerDto();
	        customerDto.setCustomerId(customerDetailsAsPerId.getCustomerId());
	        customerDto.setCustomerName(customerDetailsAsPerId.getCustomerName());
	        customerDto.setCustomerEmail(customerDetailsAsPerId.getCustomerEmail());
	        customerDto.setCustomrPhoneNumber(customerDetailsAsPerId.getCustomrPhoneNumber());

	        logger.info("getCustomerDetailsAsperId - customerDto: {}", customerDto);
	        return ResponseEntity.ok(customerDto);
	    }

	    logger.info("getCustomerDetailsAsperId - No data found for customerId: {}", customerId);
	    return null;
	}
	
	@Override
	public CustomerDto updateDetailsOfTheCustomerAsPerId(long customerId, Customer customer) {
		// TODO Auto-generated method stub
		Customer updateCustomerDetailsAsPerId = customerDao.updateCustomerDetailsAsPerId(customerId,customer);
		CustomerDto entityToCustomerClassDto = entityToCustomerClassDto(updateCustomerDetailsAsPerId);
		return entityToCustomerClassDto;
	}
	@Override
	public String deleteCustomerAsPerId(long customerId) {
		// TODO Auto-generated method stub
		ResponseEntity<CustomerDto> customerDetailsAsperId = getCustomerDetailsAsperId(customerId);
		if(customerDetailsAsperId!=null) {
			customerDao.deleteCustomerAsPerId(customerId);
			return SuccessMessages.CUSTOMER_DELETED_SUCCESSFULLY;
		}
		else {
			return ErrorMessages.SOMETHINGH_WENT_WRONG_WHILE_DELETING_DATA;
		}
		
		
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
