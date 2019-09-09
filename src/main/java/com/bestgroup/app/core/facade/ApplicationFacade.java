package com.bestgroup.app.core.facade;

import com.bestgroup.app.core.facade.strategies.customer.CreateCustomer;
import com.bestgroup.app.core.facade.strategies.customer.ReadCustomer;
import com.bestgroup.app.core.facade.strategies.customer.ValidateCustomerEmail;
import com.bestgroup.app.core.facade.strategies.customer.ValidateCustomerName;
import com.bestgroup.app.core.facade.strategies.customer.ValidateCustomerPassword;
import com.bestgroup.app.core.facade.strategies.customer.ValidateCustomerPasswordConfirmation;
import com.bestgroup.app.domain.Customer;
import com.bestgroup.core.facade.Facade;
import com.bestgroup.core.facade.Strategy;

public class ApplicationFacade extends Facade {
	

	
	public ApplicationFacade() {
		
		/*
		 * Customer strategies
		 */
		Strategy createCustomer = new CreateCustomer();
		Strategy readCustomer = new ReadCustomer(); 
		Strategy validateCustomerName = new ValidateCustomerName();
		Strategy validateCustomerEmail = new ValidateCustomerEmail();
		Strategy validateCustomerPassword = new ValidateCustomerPassword(); 
		Strategy validateCustomerPasswordConfirmation = new ValidateCustomerPasswordConfirmation();
		
		/*
		 * Customer strategy configuration
		 */
		onCreate(Customer.class,
				validateCustomerName, 
				validateCustomerEmail,
				validateCustomerPassword,
				validateCustomerPasswordConfirmation,
				createCustomer);
		
		onRead(Customer.class, readCustomer);
	}
}
