package com.solt.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Bank
 *
 */
@Entity

public class Bank implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date bank_date;
	private String description;
	private double withdraw;
	private double deposit;
	private double closingBalance;
	private static final long serialVersionUID = 1L;

	public Bank() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public Date getBank_date() {
		return this.bank_date;
	}

	public void setBank_date(Date bank_date) {
		this.bank_date = bank_date;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public double getWithdraw() {
		return this.withdraw;
	}

	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}   
	public double getDeposit() {
		return this.deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}   
	public double getClosingBalance() {
		return this.closingBalance;
	}

	public void setClosingBalance(double closingBalance) {
		this.closingBalance = closingBalance;
	}
   
}
