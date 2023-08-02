package edu.bookmyshow.project.constants;

public interface URLPaths {
	
	final String APPLICATION_BASE_VERSION_URL="api/v1";
	
	
	/*Api creation for the Customer*/
	
	final String CUSTOMER_CLASS_API=APPLICATION_BASE_VERSION_URL+"/customer";
	
	/*Post API for the saving the details of the Customer*/
	final String CUSTOMER_DETAIL_SAVE="/saveCustomer";
	
	/*GET API to get the details of the customer as per the id*/
	final String CUSTOMER_DETAILS_AS_PER_ID="/customerDetailsAsPerId";
	
	/*PUT API updating the details of the customer as per the id of the customer*/
	final String CUSTOMER_DETAILS_UPDATE_AS_PER_ID="/customerDetailsUpdate";
	
	/*DELETE API to delete the customer as per the id*/
	final String DELETE_CUSTOMER_AS_PER_ID="/deleteCustomer";
	

}
