package com.solt.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import com.solt.entities.Expense;

@Local
@Stateless
public class ExpenseDao extends AbstractDao<Expense>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExpenseDao() {
		super(Expense.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<Expense> findbyMonth(int year , int month){
		String select = "select e from Expense e where YEAR(expense_date) like "+year+" and MONTH(expense_date) like "+month;
		TypedQuery<Expense> query = em.createQuery(select,Expense.class);
		return query.getResultList();
	}
	
	public List<Expense> findbyYear(int year){
		String select = "select e from Expense e where YEAR(expense_date) like "+year;
		TypedQuery<Expense> query = em.createQuery(select,Expense.class);
		return query.getResultList();
	}

}
