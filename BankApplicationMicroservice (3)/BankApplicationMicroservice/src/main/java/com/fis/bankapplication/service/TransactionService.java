package com.fis.bankapplication.service;

import java.util.List;

import com.fis.bankapplication.exceptions.TransactionNotFound;
import com.fis.bankapplication.model.Transaction;

public interface TransactionService {
	public abstract String createTransaction(Transaction transaction);

	public abstract String updateTransaction(Transaction transaction);

	public abstract String deleteTransaction(int tranId);

	public abstract Transaction getTransaction(int tranId);

	public abstract List<Transaction> getAllTransactionByAccNumber(long accNumber);

	public abstract List<Transaction> getAllTransaction();
}
