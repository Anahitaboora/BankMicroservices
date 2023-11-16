package com.fis.bankapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fis.bankapplication.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
