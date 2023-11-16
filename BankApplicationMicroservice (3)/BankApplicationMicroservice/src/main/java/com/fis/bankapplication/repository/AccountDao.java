package com.fis.bankapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fis.bankapplication.model.Account;

public interface AccountDao extends JpaRepository<Account, Long> {

	@Query("Update Account  set accBalance=accBalance+ ?2 where accNumber=?1")
	@Modifying
	public void depositAccount(long accNumber, double amount);

	@Query("Update Account set accBalance=accBalance - ?2 where accNumber=?1")
	@Modifying
	public void withdrawAccount(long accNumber, double amount);

}
