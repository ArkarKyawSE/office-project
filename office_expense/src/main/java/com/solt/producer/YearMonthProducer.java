package com.solt.producer;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class YearMonthProducer {
	private List<Integer> year;
	private List<Integer> month;
	
	@PostConstruct
	public void init(){
		for(int i = 2017;i<=2030;i++){
			year.add(i);
		}
		for(int i = 1;i<=12;i++){
			month.add(i);
		}
	}

	public List<Integer> getYear() {
		return year;
	}

	public void setYear(List<Integer> year) {
		this.year = year;
	}

	public List<Integer> getMonth() {
		return month;
	}

	public void setMonth(List<Integer> month) {
		this.month = month;
	}
	
}
