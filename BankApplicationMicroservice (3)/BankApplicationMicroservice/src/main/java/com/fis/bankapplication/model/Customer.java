package com.fis.bankapplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//Registration

//{
//    "cusId":1,
//    "cusName":"surya",
//    "cusEmail":"surya@gmail.com",
//    "cusMob":98765432,
//    "cusAadhar":3456789,
//    "cusPrmaAdd":"up",
//    "cusResiAdd":"pune",
//    "cusDob":"29-12-2002";
//}

@Entity
@Table(name = "cus_info")
public class Customer {

	@Id
	@Column(name = "cusid")
	@Min(value = 100, message = "Customer Id Cannot be less than 100")
	@Max(value = 1000, message = "Customer Id cannot be greater than 1000")
	private int cusId;
	@Size(min = 3, max = 15, message = "Customer name length must be between 3-15")
	@NotBlank(message = "Customer name cannot be null and whitespace")
	private String cusName;
	@Email(message = "Enter valid email id")
	private String cusEmail;
	// @Pattern(regexp = "^[0-9]{10}", message ="Mobile number must be 10 digits")
	private long cusMob;
	// @Pattern(regexp = "^[0-9]{12}$", message ="Aadhar number must be 12 digits")
	private long cusAadhar;
	@NotBlank(message = "Customer permanent address must not be null")
	private String cusPrmaAdd;
	@NotBlank(message = "Customer residenatl address must not be null")
	private String cusResiAdd;
	@NotBlank(message = "Customer date of birth must not be null")
	private String cusDob;

	public Customer() {
		super();
	}

	public Customer(int cusId, String cusName, String cusEmail, long cusMob, long cusAadhar, String cusPrmaAdd,
			String cusResiAdd, String cusDob) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusEmail = cusEmail;
		this.cusMob = cusMob;
		this.cusAadhar = cusAadhar;
		this.cusPrmaAdd = cusPrmaAdd;
		this.cusResiAdd = cusResiAdd;
		this.cusDob = cusDob;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusEmail() {
		return cusEmail;
	}

	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}

	public long getCusMob() {
		return cusMob;
	}

	public void setCusMob(long cusMob) {
		this.cusMob = cusMob;
	}

	public long getCusAadhar() {
		return cusAadhar;
	}

	public void setCusAadhar(long cusAadhar) {
		this.cusAadhar = cusAadhar;
	}

	public String getCusPrmaAdd() {
		return cusPrmaAdd;
	}

	public void setCusPrmaAdd(String cusPrmaAdd) {
		this.cusPrmaAdd = cusPrmaAdd;
	}

	public String getCusResiAdd() {
		return cusResiAdd;
	}

	public void setCusResiAdd(String cusResiAdd) {
		this.cusResiAdd = cusResiAdd;
	}

	public String getCusDob() {
		return cusDob;
	}

	public void setCusDob(String cusDob) {
		this.cusDob = cusDob;
	}

	@Override
	public String toString() {
		return "Customer [cusId=" + cusId + ", cusName=" + cusName + ", cusEmail=" + cusEmail + ", cusMob=" + cusMob
				+ ", cusAadhar=" + cusAadhar + ", cusPrmaAdd=" + cusPrmaAdd + ", cusResiAdd=" + cusResiAdd + ", cusDob="
				+ cusDob + "]";
	}

}
