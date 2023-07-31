package edu.bookmyshow.project.contyroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.bookmyshow.project.constants.URLPaths;
import edu.bookmyshow.project.dto.CustomerDto;
import edu.bookmyshow.project.entity.Customer;
import edu.bookmyshow.project.serviceinterface.CustomerServiceInterface;

@RestController
@RequestMapping(value = URLPaths.CUSTOMER_CLASS_API)
public class CustomerController {
	
	@Autowired
	CustomerServiceInterface customerServiceInterface;
	
	@PostMapping(value = URLPaths.CUSTOMER_DETAIL_SAVE)
	public ResponseEntity<CustomerDto> saveTheCustomerDetails(@RequestBody Customer customer){
		CustomerDto saveCustomerDetails = customerServiceInterface.saveCustomerDetails(customer);
		return ResponseEntity.ok(saveCustomerDetails);
	}
	

}
