package com.solt.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import com.solt.entities.Expense;

public class ExpenseDao extends AbstractDao<Expense>{

	public ExpenseDao(Class<Expense> type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	
	public List<Expense> findbyMonth(int year , int month){
		String select = "select * from expense where expense_date.year like "+year+" and expense_date.month like "+month;
		TypedQuery<Expense> query = em.createQuery(select,Expense.class);
		return query.getResultList();
	}
	
	public List<Expense> findbyYear(int year){
		String select = "select * from expense where expense_date.year like "+year;
		TypedQuery<Expense> query = em.createQuery(select,Expense.class);
		return query.getResultList();
	}

}
