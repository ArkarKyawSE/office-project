package com.solt.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.solt.dao.HomeDao;
import com.solt.entities.Home;
import com.solt.utility.CategoryComparator;
import com.solt.utility.DateComparator;

@Named
@RequestScoped
public class HomeBean {
	private List<Home> homes;
	@Inject
	private HomeDao hDao;
	private int year;
	private int month;
	private double remainBalance;
	
	@PostConstruct
	public void init(){
		homes = hDao.findAll();
		calculateRemainBalance();
	}
	
	public void search(){
		if (year != 0 & month != 0) {
			homes = hDao.findbyMonth(year, month);
			homes.sort(new CategoryComparator());
		} else if (year != 0) {
			homes = hDao.findbyYear(year);
			homes.sort(new DateComparator());
		} else {
			homes = hDao.findAll();
			homes.sort(new DateComparator());
		}
		calculateRemainBalance();
	}
	
	public void calculateRemainBalance(){
		remainBalance = homes.stream().mapToDouble(h -> h.getIncome()).sum()-homes.stream().mapToDouble(h -> h.getExpense()).sum();
	}
	
	public void print(){
		
	}

	public List<Home> getHomes() {
		return homes;
	}

	public void setHomes(List<Home> homes) {
		this.homes = homes;
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

	public int getRemainBalance() {
		return (int)remainBalance;
	}

	public void setRemainBalance(double remainBalance) {
		this.remainBalance = remainBalance;
	}
	
}
