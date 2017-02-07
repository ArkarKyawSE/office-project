package com.solt.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.solt.dao.IncomeDao;
import com.solt.entities.Income;
import com.solt.entities.Income.CLASSTYPE;

@Named
@RequestScoped
public class IncomeBean {
	private	Income income;
	private List<Income> incomes;
	@Inject
	private IncomeDao incomeDao;
	private double totalSE;
	private double totalEE;
	private double totalWEB;
	private double totalONESTOP;
	private double totalIncome;
	private double totalOTHER;
	
	private int year;
	private int month;
	
	@PostConstruct
	public void init(){
		incomes = incomeDao.findAll();
		income = new Income();
		calculateTotal();
	}
	
	public void search(){
		if (year != 0 & month != 0) {
			incomes = incomeDao.findbyMonth(year, month);
		} else if (year != 0) {
			incomes = incomeDao.findbyYear(year);
		} else {
			incomes = incomeDao.findAll();
		}
		calculateTotal();
	}

	private void calculateTotal() {
		totalSE = incomes.stream().filter(a -> a.getClassType().equals(CLASSTYPE.JAVASE)).mapToDouble(a -> a.getAmount()).sum();
		totalEE = incomes.stream().filter(a -> a.getClassType().equals(CLASSTYPE.JAVAEE)).mapToDouble(a -> a.getAmount()).sum();
		totalWEB = incomes.stream().filter(a -> a.getClassType().equals(CLASSTYPE.JAVAWEB)).mapToDouble(a -> a.getAmount()).sum();
		totalONESTOP = incomes.stream().filter(a -> a.getClassType().equals(CLASSTYPE.ONESTOP)).mapToDouble(a -> a.getAmount()).sum();
		totalOTHER = incomes.stream().filter(a -> a.getClassType().equals(CLASSTYPE.OTHER)).mapToDouble(a -> a.getAmount()).sum();
		totalIncome = incomes.stream().mapToDouble(a -> a.getAmount()).sum();
	}

	public String addIncome(){
		incomeDao.insert(income);
		return "/views/income?faces-redirect=true";
	}

	public Income getIncome() {
		return income;
	}

	public void setIncome(Income income) {
		this.income = income;
	}

	public double getTotalSE() {
		return totalSE;
	}

	public void setTotalSE(double totalSE) {
		this.totalSE = totalSE;
	}

	public double getTotalEE() {
		return totalEE;
	}

	public void setTotalEE(double totalEE) {
		this.totalEE = totalEE;
	}

	public double getTotalWEB() {
		return totalWEB;
	}

	public void setTotalWEB(double totalWEB) {
		this.totalWEB = totalWEB;
	}

	public double getTotalONESTOP() {
		return totalONESTOP;
	}

	public void setTotalONESTOP(double totalONESTOP) {
		this.totalONESTOP = totalONESTOP;
	}

	public double getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(double totalIncome) {
		this.totalIncome = totalIncome;
	}

	public double getTotalOTHER() {
		return totalOTHER;
	}

	public void setTotalOTHER(double totalOTHER) {
		this.totalOTHER = totalOTHER;
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
}
