package com.fis.bankapplication;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fis.bankapplication.model.Account;
import com.fis.bankapplication.model.Customer;
import com.fis.bankapplication.service.AccountService;
import com.fis.bankapplication.service.CustomerService;

@SpringBootTest
class BankApplicationTests {
	
	@Autowired
	CustomerService cusService;
	
	@Autowired
	AccountService accService;

	@Test
	public void testAddCustomer() {
		Customer cus=new Customer(111,"skchandra","skc@gmail.com",9876543,4335567,"up","pune","29-12-2002");
		String msg=cusService.createCustomer(cus);
		assertEquals("Customer created succefful",msg);
	}
	
	@Test
	public void testAddAccount() {
		Account acc=new Account(111l,568d,"pune",LocalDate.now(),"saving");
		String msg=accService.createAccount(acc);
		assertEquals("Account creted successful",msg);
	}

}
