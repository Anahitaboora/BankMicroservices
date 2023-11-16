package com.fis.bankapplication.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

//{
//    "tranId":1,
//    "tranFromAccount":111111,
//    "tranToAccount":222222,
//    "tranAmount":10000,
//    "tranTime":"12:12",
//    "tranType":"Fund transfer",
//    "tranStatus":"success"
//
//}

@Entity
@Table(name = "trans_info")
public class Transaction {
	@Id
	@GeneratedValue
	private int tranId;
	private long tranFromAccount;
	private long tranToAccount;
	@Positive(message = "Transaction amount must be positive")
	private double tranAmount;
	private Date tranTime = new Date();
	private String tranType;
	private String tranStatus;

	public Transaction() {
		super();
	}

	public Transaction(long tranFromAccount, long tranToAccount, double tranAmount, Date tranTime, String tranType,
			String tranStatus) {
		super();
		this.tranFromAccount = tranFromAccount;
		this.tranToAccount = tranToAccount;
		this.tranAmount = tranAmount;
		this.tranTime = tranTime;
		this.tranType = tranType;
		this.tranStatus = tranStatus;
	}

	public Transaction(int tranId, long tranFromAccount, long tranToAccount, double tranAmount, Date tranTime,
			String tranType, String tranStatus) {
		super();
		this.tranId = tranId;
		this.tranFromAccount = tranFromAccount;
		this.tranToAccount = tranToAccount;
		this.tranAmount = tranAmount;
		this.tranTime = tranTime;
		this.tranType = tranType;
		this.tranStatus = tranStatus;
	}

	public int getTranId() {
		return tranId;
	}

	public void setTranId(int tranId) {
		this.tranId = tranId;
	}

	public long getTranFromAccount() {
		return tranFromAccount;
	}

	public void setTranFromAccount(long tranFromAccount) {
		this.tranFromAccount = tranFromAccount;
	}

	public long getTranToAccount() {
		return tranToAccount;
	}

	public void setTranToAccount(long tranToAccount) {
		this.tranToAccount = tranToAccount;
	}

	public double getTranAmount() {
		return tranAmount;
	}

	public void setTranAmount(double tranAmount) {
		this.tranAmount = tranAmount;
	}

	public Date getTranTime() {
		return tranTime;
	}

	public void setTranTime(Date tranTime) {
		this.tranTime = tranTime;
	}

	public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	public String getTranStatus() {
		return tranStatus;
	}

	public void setTranStatus(String tranStatus) {
		this.tranStatus = tranStatus;
	}

	@Override
	public String toString() {
		return String.format(
				"Transaction [tranId=%s, tranFromAccount=%s, tranToAccount=%s, tranAmount=%s, tranTime=%s, tranType=%s, tranStatus=%s]",
				tranId, tranFromAccount, tranToAccount, tranAmount, tranTime, tranType, tranStatus);
	}

}
