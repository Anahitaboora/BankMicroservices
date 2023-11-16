package com.fis.bankapplication.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

//{
//    "accNumber":444444,
//    "accBalance":40000,
//    "accBranch":"aundh",
//    "accOpenDate":"01-01-2020",
//    "accType":"saving"
// 
//}
@Entity
@Table(name = "acc_info")
public class Account {

	@Id
	@Min(value = 100, message = "Account Number Cannot be less than 100")
	@Max(value = 1000, message = "Account Number cannot be greater than 1000")
	private long accNumber;
	private double accBalance;
	@NotBlank(message = "Account Branch must not be null ")
	private String accBranch;
	private LocalDate accOpenDate = LocalDate.now();
	@NotBlank(message = "Account type must not be null ")
	private String accType;

	public Account() {
		super();
	}

	
	
	public Account(
			@Min(value = 100, message = "Account Number Cannot be less than 100") @Max(value = 1000, message = "Account Number cannot be greater than 1000") long accNumber,
			double accBalance, @NotBlank(message = "Account Branch must not be null ") String accBranch,
			@NotBlank(message = "Account type must not be null ") String accType) {
		super();
		this.accNumber = accNumber;
		this.accBalance = accBalance;
		this.accBranch = accBranch;
		this.accType = accType;
	}



	public Account(long accNumber, double accBalance, String accBranch, LocalDate accOpenDate, String accType) {
		super();
		this.accNumber = accNumber;
		this.accBalance = accBalance;
		this.accBranch = accBranch;
		this.accOpenDate = accOpenDate;
		this.accType = accType;
	}

	public long getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	public String getAccBranch() {
		return accBranch;
	}

	public void setAccBranch(String accBranch) {
		this.accBranch = accBranch;
	}

	public LocalDate getAccOpenDate() {
		return accOpenDate;
	}

	public void setAccOpenDate(LocalDate accOpenDate) {
		this.accOpenDate = accOpenDate;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	@Override
	public String toString() {
		return String.format("Account [accNumber=%s, accBalance=%s, accBranch=%s, accOpenDate=%s, accType=%s]",
				accNumber, accBalance, accBranch, accOpenDate, accType);
	}

}
