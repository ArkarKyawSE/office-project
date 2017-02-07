package com.solt.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.solt.dao.HomeDao;
import com.solt.entities.Home;
import com.solt.entities.Income.CLASSTYPE;

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
	}
	
	public void search(){
		if (year != 0 & month != 0) {
			homes = hDao.findbyMonth(year, month);
		} else if (year != 0) {
			homes = hDao.findbyYear(year);
		} else {
			homes = hDao.findAll();
		}
	}
	
	public void calculateRemainBalance(){
	
	}
	
	public void print(){
		
	}

}
