package com.fis.bankapplication.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.bankapplication.exceptions.TransactionNotFound;
import com.fis.bankapplication.model.Account;
import com.fis.bankapplication.model.Transaction;
import com.fis.bankapplication.repository.TransactionDao;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionDao tranDao;

	@Override
	public String createTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		tranDao.save(transaction);
		return "Transaction created successful...";
	}

	@Override
	public String updateTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		tranDao.save(transaction);
		return "Transaction updated successful...";
	}

	@Override
	public String deleteTransaction(int tranId) {
		// TODO Auto-generated method stub
		tranDao.deleteById(tranId);
		return "Transaction deleted successful...";
	}

	@Override
	public Transaction getTransaction(int tranId) {
		// TODO Auto-generated method stub
		Optional<Transaction> optional = tranDao.findById(tranId);
		return optional.get();
	}

	@Override
	public List<Transaction> getAllTransaction() {
		// TODO Auto-generated method stub
		return tranDao.findAll();
	}

	@Override
	public List<Transaction> getAllTransactionByAccNumber(long accNumber) {
		// TODO Auto-generated method stub
		return tranDao.getAllTransactionByAccNumber(accNumber);
	}

}
