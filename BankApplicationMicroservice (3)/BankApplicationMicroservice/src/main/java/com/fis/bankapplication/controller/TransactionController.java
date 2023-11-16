package com.fis.bankapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.bankapplication.model.Transaction;
import com.fis.bankapplication.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	TransactionService tranService;

	@PostMapping("/create")
	public String createTransaction(@RequestBody Transaction transaction) {
		return tranService.createTransaction(transaction);
	}

	@PutMapping("/update")
	public String updateTransaction(@RequestBody Transaction transaction) {
		return tranService.updateTransaction(transaction);
	}

	@DeleteMapping("/delete/{tranid}")
	public String deleteTransaction(@PathVariable("tranid") int tranId) {
		return tranService.deleteTransaction(tranId);
	}

	@GetMapping("/gettransaction/{tranid}")
	public Transaction getTransaction(@PathVariable("tranid") int tranId) {
		return tranService.getTransaction(tranId);
	}

	@GetMapping("/getalltransactionbyaccnum/{accnum}")
	public List<Transaction> getAllTransactionByAccNumber(@PathVariable("accnum") long accnum) {
		return tranService.getAllTransactionByAccNumber(accnum);
	}

	@GetMapping("/getalltransaction")
	public List<Transaction> getAllTransactionList() {
		return tranService.getAllTransaction();
	}

}
