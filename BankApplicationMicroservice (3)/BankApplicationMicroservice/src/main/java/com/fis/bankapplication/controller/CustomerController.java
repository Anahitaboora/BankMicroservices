package com.fis.bankapplication.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fis.bankapplication.exceptions.CustomerNotFound;
import com.fis.bankapplication.model.Customer;
import com.fis.bankapplication.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService cusService;
	

	@PostMapping("/create")
	public String createCustomer(@RequestBody @Validated Customer customer) // http://localhost:8080/customer/createCustomer
	{
		return cusService.createCustomer(customer);
	}

	@PutMapping("/update")
	public String updateCustomer(@RequestBody Customer customer) {
		return cusService.updateCustomer(customer);
	}

	@DeleteMapping("/delete/{cusid}")
	public String deleteCustomer(@PathVariable("cusid") int cusId) {
		try {
		return cusService.deleteCustomer(cusId);
		}catch(CustomerNotFound cnf) {
			return cnf.getMessage();
		}
	}

	@GetMapping("/getbyid/{cusid}")
	public Customer getCustomerById(@PathVariable("cusid") int cusId) {
		
		return cusService.getCustomerById(cusId);
		
		
	}

	@GetMapping("/getall")
	public List<Customer> getAllCustomer() {
		return cusService.getAllCustomer();
	}

}
