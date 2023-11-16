package com.fis.bankapplication.service;

import java.util.List;

import com.fis.bankapplication.exceptions.AccountNotFoundException;
import com.fis.bankapplication.exceptions.NotEnoughBalanceException;
import com.fis.bankapplication.model.Account;

public interface AccountService {
	public abstract String createAccount(Account account);

	public abstract String updateAccount(Account account);

	public abstract String deleteAccount(long accNumber);

	public abstract Account getAccount(long accNumber);

	public abstract String depositAccount(long accNumber, double amount) throws AccountNotFoundException;

	public abstract String withdrawAccount(long accNumber, double amount)
			throws NotEnoughBalanceException, AccountNotFoundException;

	public abstract String FundTransferAccount(long fromAccNumber, long toAccNumber, double amount)
			throws NotEnoughBalanceException, AccountNotFoundException;

	public abstract List<Account> getAccountList();
}
