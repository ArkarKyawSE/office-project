package com.solt.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.solt.dao.ExpenseDao;
import com.solt.entities.Expense;
import com.solt.entities.Expense.EXPENSECATEGORY;

@Named
@RequestScoped
public class ExpenseBean {
	private Expense expnese;
	private List<Expense> expenses;
	
	@Inject
	private ExpenseDao exDao;
	private int year;
	private int month;
	private double totalTax;
	private double totalBill;
	private double totalMaintain;
	private double totalOffice;
	private double totalPayRoll;
	private double totalEmpTrain;
	private double totalRoomRental;
	private double totalOthers;
	private double totalAll;

	@PostConstruct
	public void init() {
		expenses = exDao.findAll();		
		expnese = new Expense();
		calculateTotal();
	}
	
	public void search(){
		if (year != 0 & month != 0) {
			expenses = exDao.findbyMonth(year, month);
		} else if (year != 0) {
			expenses = exDao.findbyYear(year);
		} else {
			expenses = exDao.findAll();
		}
		calculateTotal();
	}
	
	public void calculateTotal(){
		
		totalTax = expenses.stream().filter(a -> a.getExpense_category().equals(EXPENSECATEGORY.TAX)).mapToDouble(a -> a.getAmount()).sum();
		totalBill = expenses.stream().filter(a -> a.getExpense_category().equals(EXPENSECATEGORY.BILL)).mapToDouble(a -> a.getAmount()).sum();
		totalMaintain = expenses.stream().filter(a -> a.getExpense_category().equals(EXPENSECATEGORY.MAINTAINENCE)).mapToDouble(a -> a.getAmount()).sum();
		totalOffice = expenses.stream().filter(a -> a.getExpense_category().equals(EXPENSECATEGORY.OFFICE_ITEM)).mapToDouble(a -> a.getAmount()).sum();
		totalPayRoll = expenses.stream().filter(a -> a.getExpense_category().equals(EXPENSECATEGORY.PAY_ROLL)).mapToDouble(a -> a.getAmount()).sum();
		totalEmpTrain = expenses.stream().filter(a -> a.getExpense_category().equals(EXPENSECATEGORY.EMPLOYEE_TRAINNING)).mapToDouble(a -> a.getAmount()).sum();
		totalRoomRental = expenses.stream().filter(a -> a.getExpense_category().equals(EXPENSECATEGORY.ROOM_RENTAL)).mapToDouble(a -> a.getAmount()).sum();
		totalOthers = expenses.stream().filter(a -> a.getExpense_category().equals(EXPENSECATEGORY.OTHER)).mapToDouble(a -> a.getAmount()).sum();
		totalAll = expenses.stream().mapToDouble(a -> a.getAmount()).sum();
		
	}
	
	public String addExpense(){
		exDao.insert(expnese);
		return "/views/expense?faces-redirect=true";
	}

	public Expense getExpnese() {
		return expnese;
	}

	public void setExpnese(Expense expnese) {
		this.expnese = expnese;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getTotalTax() {
		return (int)totalTax;
	}

	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}

	public int getTotalBill() {
		return (int)totalBill;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	public int getTotalMaintain() {
		return (int)totalMaintain;
	}

	public void setTotalMaintain(double totalMaintain) {
		this.totalMaintain = totalMaintain;
	}

	public int getTotalOffice() {
		return (int)totalOffice;
	}

	public void setTotalOffice(double totalOffice) {
		this.totalOffice = totalOffice;
	}

	public int getTotalPayRoll() {
		return (int)totalPayRoll;
	}

	public void setTotalPayRoll(double totalPayRoll) {
		this.totalPayRoll = totalPayRoll;
	}

	public int getTotalEmpTrain() {
		return (int)totalEmpTrain;
	}

	public void setTotalEmpTrain(double totalEmpTrain) {
		this.totalEmpTrain = totalEmpTrain;
	}

	public int getTotalRoomRental() {
		return (int)totalRoomRental;
	}

	public void setTotalRoomRental(double totalRoomRental) {
		this.totalRoomRental = totalRoomRental;
	}

	public int getTotalOthers() {
		return (int)totalOthers;
	}

	public void setTotalOthers(double totalOthers) {
		this.totalOthers = totalOthers;
	}

	public int getTotalAll() {
		return (int)totalAll;
	}

	public void setTotalAll(double totalAll) {
		this.totalAll = totalAll;
	}
	
	
	
}
