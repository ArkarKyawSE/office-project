package com.solt.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Income
 *
 */
@Entity

public class Income implements Serializable {

	public enum CLASSTYPE{
		JAVASE , JAVAEE , JAVAWEB , ONESTOP , OTHER
	}
	@Id
	private int id;
	private Date income_date;
	@Enumerated
	private CLASSTYPE classType;
	private double amount;
	private String remark;
	private static final long serialVersionUID = 1L;

	public Income() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public Date getIncome_date() {
		return this.income_date;
	}

	public void setIncome_date(Date income_date) {
		this.income_date = income_date;
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
	public CLASSTYPE getClassType() {
		return classType;
	}
	public void setClassType(CLASSTYPE classType) {
		this.classType = classType;
	}
   
}
