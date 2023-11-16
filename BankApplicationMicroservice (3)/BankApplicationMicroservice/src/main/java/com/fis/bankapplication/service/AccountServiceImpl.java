package com.fis.bankapplication.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.bankapplication.exceptions.AccountNotFoundException;
import com.fis.bankapplication.exceptions.NotEnoughBalanceException;
import com.fis.bankapplication.model.Account;
import com.fis.bankapplication.model.Transaction;
import com.fis.bankapplication.repository.AccountDao;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao accDao;

	@Autowired
	TransactionService tranService;

	@Override
	public String createAccount(Account account) {
		// TODO Auto-generated method stub
		accDao.save(account);
		return "Account creted successful";
	}

	@Override
	public String updateAccount(Account account) {
		// TODO Auto-generated method stub
		accDao.save(account);
		return "Account updated successful";
	}

	@Override
	public String deleteAccount(long accNumber) {
		// TODO Auto-generated method stub
		accDao.deleteById(accNumber);
		return "Account deleted successful";
	}

	@Override
	public Account getAccount(long accNumber)  {
		// TODO Auto-generated method stub
		Optional<Account> optional = accDao.findById(accNumber);
		return optional.get();
	

	}

	@Override
	public List<Account> getAccountList() {
		// TODO Auto-generated method stub
		return accDao.findAll();
	}

	@Override
	public String depositAccount(long accNumber, double amount) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		Optional<Account> optional = accDao.findById(accNumber);
		if (optional.isPresent()) {
			accDao.depositAccount(accNumber, amount);
			return "Amount Deposit successful...";
		} else {
			throw new AccountNotFoundException("Account number is wrong !!!");
		}
	}

	@Override
	public String withdrawAccount(long accNumber, double amount)
			throws NotEnoughBalanceException, AccountNotFoundException {
		// TODO Auto-generated method stub
		Optional<Account> optional = accDao.findById(accNumber);
		if (optional.isPresent()) {
			Account acc = optional.get();
			double currBalance = acc.getAccBalance();
			if (currBalance < amount) {
				throw new NotEnoughBalanceException("Balance is not sufficient !!!");
			} else {
				accDao.withdrawAccount(accNumber, amount);
				return "Amount withdraw successful...";
			}
		} else {
			throw new AccountNotFoundException("Account number is wrong !!!");
		}

	}

	@Override
	public String FundTransferAccount(long fromAccNumber, long toAccNumber, double amount)
			throws NotEnoughBalanceException, AccountNotFoundException {

		Optional<Account> optional = accDao.findById(fromAccNumber);
		Optional<Account> optional1 = accDao.findById(toAccNumber);
		if (optional.isPresent() & optional1.isPresent()) {
			Account acc = optional.get();
			double currBalance = acc.getAccBalance();
			if (currBalance < amount) {
				;
				Transaction tran = new Transaction(fromAccNumber, toAccNumber, amount, new Date(), "Fund transfer",
						"failed");
				tranService.createTransaction(tran);
				throw new NotEnoughBalanceException("Balance is not sufficient !!!");

			} else {
				accDao.withdrawAccount(fromAccNumber, amount);
				accDao.depositAccount(toAccNumber, amount);
				Transaction tran = new Transaction(fromAccNumber, toAccNumber, amount, new Date(), "Fund transfer",
						"succes");
				tranService.createTransaction(tran);
				return "Fund Transfer successful...";
			}
		} else {
			Transaction tran = new Transaction(fromAccNumber, toAccNumber, amount, new Date(), "Fund transfer",
					"failed");
			tranService.createTransaction(tran);
			throw new AccountNotFoundException("Account number is wrong !!!");
		}

	}

}
