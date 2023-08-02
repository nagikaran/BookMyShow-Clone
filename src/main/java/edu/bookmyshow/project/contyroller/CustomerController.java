package edu.bookmyshow.project.contyroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.bookmyshow.project.constants.ErrorMessages;
import edu.bookmyshow.project.constants.URLPaths;
import edu.bookmyshow.project.dto.CustomerDto;
import edu.bookmyshow.project.entity.Customer;
import edu.bookmyshow.project.serviceinterface.CustomerServiceInterface;

@RestController
@RequestMapping(value = URLPaths.CUSTOMER_CLASS_API)
public class CustomerController {
	
	@Autowired
	CustomerServiceInterface customerServiceInterface;

	/* api to save the details of the customer */
	@PostMapping(value = URLPaths.CUSTOMER_DETAIL_SAVE)
	public ResponseEntity<CustomerDto> saveTheCustomerDetails(@RequestBody Customer customer) {
		CustomerDto saveCustomerDetails = customerServiceInterface.saveCustomerDetails(customer);
		return ResponseEntity.ok(saveCustomerDetails);
	}

	/* api to get the detauls of the customer as per the id */
	@GetMapping(value = URLPaths.CUSTOMER_DETAILS_AS_PER_ID + "/{customerId}")
	public ResponseEntity<?> getTheDetailsOfTheCustomer(@PathVariable long customerId) {

		try {
			ResponseEntity<CustomerDto> customerDetailsAsperId = customerServiceInterface
					.getCustomerDetailsAsperId(customerId);
			if (customerDetailsAsperId != null) {
				return ResponseEntity.ok(customerDetailsAsperId);
			} else if (customerDetailsAsperId == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorMessages.NO_DATA_FOUND_FOR_THESE_ID);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorMessages.NO_DATA_FOUND_FOR_THESE_ID);
			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorMessages.SOME_SERVER_SIDE_ISSUES);
		}

	}

	/* API to update the details of the customer */
	@PutMapping(value = URLPaths.CUSTOMER_DETAILS_UPDATE_AS_PER_ID + "/{customerId}")
	public ResponseEntity<CustomerDto> updatingTheDetailsOfTheCustomer(@PathVariable long customerId,@RequestBody Customer customer) {
		CustomerDto updateDetailsOfTheCustomerAsPerId = customerServiceInterface.updateDetailsOfTheCustomerAsPerId(customerId, customer);
	    return ResponseEntity.ok(updateDetailsOfTheCustomerAsPerId);
	}
	

}
