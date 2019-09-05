package com.bestgroup.app.core.facade;

import com.bestgroup.app.core.facade.strategies.category.CreateCategory;
import com.bestgroup.app.core.facade.strategies.category.DeleteCategory;
import com.bestgroup.app.core.facade.strategies.category.UpdateCategory;
import com.bestgroup.app.core.facade.strategies.category.ValidateCategoryDescription;
import com.bestgroup.app.core.facade.strategies.category.ValidateCategoryName;
import com.bestgroup.app.core.facade.strategies.category.VerifyCategoryExistence;
import com.bestgroup.app.core.facade.strategies.customer.CreateCustomer;
import com.bestgroup.app.core.facade.strategies.customer.ReadCustomer;
import com.bestgroup.app.core.facade.strategies.customer.ValidateCustomerEmail;
import com.bestgroup.app.core.facade.strategies.customer.ValidateCustomerName;
import com.bestgroup.app.core.facade.strategies.customer.ValidateCustomerPassword;
import com.bestgroup.app.core.facade.strategies.customer.ValidateCustomerPasswordConfirmation;
import com.bestgroup.app.domain.Category;
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
		 * Category strategies 
		 */
		Strategy validateCategoryName = new ValidateCategoryName();
		Strategy validateCategoryDescription = new ValidateCategoryDescription();
		Strategy verifyCategoryExistence = new VerifyCategoryExistence();
		Strategy createCategory = new CreateCategory();
		Strategy updateCategory = new UpdateCategory();
		Strategy deleteCategory = new DeleteCategory();
		
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
		
		/*
		 * Category strategy configuration
		 */
		onCreate(Category.class, 
				validateCategoryName,
				validateCategoryDescription,
				verifyCategoryExistence,
				createCategory);
		
		onUpdate(Category.class, 
				validateCategoryName,
				validateCategoryDescription,
				verifyCategoryExistence,
				updateCategory);
		
		onDelete(Category.class,
				deleteCategory);
	}
}
