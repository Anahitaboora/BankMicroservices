package com.fis.bankapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fis.bankapplication.model.Transaction;

public interface TransactionDao extends JpaRepository<Transaction, Integer> {

	@Query("select t from Transaction t where t.tranFromAccount=?1")
	public abstract List<Transaction> getAllTransactionByAccNumber(long accNumber);

}
