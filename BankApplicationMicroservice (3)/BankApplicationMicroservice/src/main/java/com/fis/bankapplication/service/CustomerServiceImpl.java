package com.fis.bankapplication.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.bankapplication.exceptions.AccountNotFoundException;
import com.fis.bankapplication.exceptions.CustomerNotFound;
import com.fis.bankapplication.model.Customer;
import com.fis.bankapplication.repository.CustomerDao;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao cusDao;

	@Override
	public String createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		cusDao.save(customer);
		return "Customer created succefful";
	}

	@Override
	public String updateCustomer(Customer customer) {
		// TODO Auto-generated method stub

		cusDao.save(customer);
		return "Customer updated successful";
	}

	@Override
	public String deleteCustomer(int cusId) throws CustomerNotFound {
		// TODO Auto-generated method stub
		Optional<Customer> optional = cusDao.findById(cusId);
		if (optional.isPresent()) {
			cusDao.deleteById(cusId);
			return "Customer deleted successful";
		} else {
			throw new CustomerNotFound("Customer Id is invalid...");
		}
	}

	@Override
	public Customer getCustomerById(int cusId)  {
		// TODO Auto-generated method stub
		Optional<Customer> optional = cusDao.findById(cusId);
		return optional.get();
		
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return cusDao.findAll();
	}

}
