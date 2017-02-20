package com.solt.entities;

import java.util.Date;

public class Home {
	public enum CATEGORY {
		TAX , BILL , MAINTAINENCE , OFFICE_ITEM , PAY_ROLL, EMPLOYEE_TRAINNING , ROOM_RENTAL , OTHER_INCOME , JAVASE , JAVAEE , JAVAWEB , ONESTOP , OTHER_EXPENSE 
	}
	
	private Date date;
	private CATEGORY category;
	private String remark;
	private double income;
	private double expense;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getIncome() {
		return (int)income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public int getExpense() {
		return (int)expense;
	}
	public void setExpense(double expense) {
		this.expense = expense;
	}
	public CATEGORY getCategory() {
		return category;
	}
	public void setCategory(CATEGORY category) {
		this.category = category;
	}
	
}
