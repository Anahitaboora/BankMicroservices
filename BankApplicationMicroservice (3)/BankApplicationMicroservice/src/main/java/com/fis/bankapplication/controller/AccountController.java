package com.fis.bankapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.bankapplication.exceptions.AccountNotFoundException;
import com.fis.bankapplication.exceptions.NotEnoughBalanceException;
import com.fis.bankapplication.model.Account;
import com.fis.bankapplication.model.Transaction;
import com.fis.bankapplication.service.AccountService;
import com.fis.bankapplication.service.TransactionService;

@RestController
@RequestMapping("/account")
public class AccountController {

	long tranFromAccount;
	long tranToAccount;
	double tranAmount;
	String tranType;
	String tranStatus;

	@Autowired
	AccountService accService;

	@Autowired
	TransactionService tranService;

	@PostMapping("/create")
	public String createAccount(@RequestBody @Validated Account account) {
		return accService.createAccount(account);
	}

	@PutMapping("/update")
	public String updateAccount(@RequestBody Account account) {
		return accService.updateAccount(account);
	}

	@DeleteMapping("/delete/{accnum}")
	public String deleteAccount(@PathVariable("accnum") long accNumber) {
		return accService.deleteAccount(accNumber);
	}

	@GetMapping("/getaccount/{accnum}")
	public Account getAccount(@PathVariable("accnum") long accNumber) {
		return accService.getAccount(accNumber);
	}

	@GetMapping("/getaccountlist")
	public List<Account> getAccountList() {
		return accService.getAccountList();
	}

	@GetMapping("/deposit/{accnum}/{amount}")
	public String depositAccount(@PathVariable("accnum") long accNumber, @PathVariable("amount") double amount) {
		Transaction transaction = new Transaction();
		tranFromAccount = accNumber;
		tranAmount = amount;
		tranType = "Deposit";

		try {
			tranStatus = "Success";
			return accService.depositAccount(accNumber, amount);

		} catch (AccountNotFoundException anf) {
			tranStatus = "Failed";
			return anf.getMessage();
		} finally {
			transaction.setTranFromAccount(accNumber);
			transaction.setTranAmount(amount);
			transaction.setTranType(tranType);
			transaction.setTranStatus(tranStatus);
			tranService.createTransaction(transaction);
		}

	}

	@GetMapping("/withdraw/{accnum}/{amount}")
	public String withdrawAccount(@PathVariable("accnum") long accNumber, @PathVariable("amount") double amount) {
		Transaction transaction = new Transaction();
		tranFromAccount = accNumber;
		tranAmount = amount;
		tranType = "Withdraw";
		try {
			tranStatus = "Success";
			return accService.withdrawAccount(accNumber, amount);
		} catch (AccountNotFoundException anf) {
			tranStatus = "Failed";
			return anf.getMessage();
		} catch (NotEnoughBalanceException nef) {
			tranStatus = "Failed";
			return nef.getMessage();
		} finally {
			transaction.setTranFromAccount(accNumber);
			transaction.setTranAmount(amount);
			transaction.setTranType(tranType);
			transaction.setTranStatus(tranStatus);
			tranService.createTransaction(transaction);
		}
	}

	// public abstract String FundTransferAccount(long fromAccNumber,long
	// toAccNumber,double amount);
	@GetMapping("/fundtransfer/{fromaccnum}/{toaccnum}/{amount}")
	public String FundTransferAccount(@PathVariable("fromaccnum") long fromAccNumber,
			@PathVariable("toaccnum") long toAccNumber, @PathVariable("amount") double amount) {
		try {
			return accService.FundTransferAccount(fromAccNumber, toAccNumber, amount);
		} catch (AccountNotFoundException anf) {

			return anf.getMessage();
		} catch (NotEnoughBalanceException nef) {
			return nef.getMessage();
		}
	}

}
