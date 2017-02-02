package com.solt.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Expense
 *
 */
@Entity

public class Expense implements Serializable {

	public enum EXPENSECATEGORY{
		TAX , BILL , MAINTAINENCE , OFFICE_ITEM , PAY_ROLL, EMPLOYEE_TRAINNING , ROOM_RENTAL , OTHER
	}
	@Id
	private int id;
	private Date expense_date;
	@Enumerated
	private EXPENSECATEGORY expense_category;
	private double amount;
	private String remark;
	private static final long serialVersionUID = 1L;

	public Expense() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public Date getExpense_date() {
		return this.expense_date;
	}

	public void setExpense_date(Date expense_date) {
		this.expense_date = expense_date;
	}   
	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}   
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public EXPENSECATEGORY getExpense_category() {
		return expense_category;
	}
	public void setExpense_category(EXPENSECATEGORY expense_category) {
		this.expense_category = expense_category;
	}
   
}
