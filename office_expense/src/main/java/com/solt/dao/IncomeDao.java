package com.solt.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import com.solt.entities.Expense;
import com.solt.entities.Income;

public class IncomeDao extends AbstractDao<Income>{

	public IncomeDao(Class<Income> type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	
	public List<Income> findbyMonth(int year, int month){
		String select = "select * from income where income_date.year like "+year+" and income_date.month like "+month;
		TypedQuery<Income> query = em.createQuery(select,Income.class);
		return query.getResultList();
	}
	
	
	public List<Income> findbyYear(int year){
		String select = "select * from income where income_date.year like "+year;
		TypedQuery<Income> query = em.createQuery(select,Income.class);
		return query.getResultList();
	}

}
