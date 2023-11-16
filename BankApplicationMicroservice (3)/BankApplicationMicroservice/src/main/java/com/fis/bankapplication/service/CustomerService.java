package com.fis.bankapplication.service;

import java.util.List;

import com.fis.bankapplication.exceptions.CustomerNotFound;
import com.fis.bankapplication.model.Customer;

public interface CustomerService {

	public abstract String createCustomer(Customer customer);

	public abstract String updateCustomer(Customer customer);

	public abstract String deleteCustomer(int cusId)throws CustomerNotFound;

	public abstract Customer getCustomerById(int cusId);

	public abstract List<Customer> getAllCustomer();
}
