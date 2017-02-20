package com.solt.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import com.solt.entities.Income;

@Remote
@Stateless
public class IncomeDao extends AbstractDao<Income>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public IncomeDao() {
		super(Income.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<Income> findbyMonth(int year, int month){
		String select = "select i from Income i where YEAR(income_date) like "+year+" and MONTH(income_date) like "+month;
		System.out.println(select);
		TypedQuery<Income> query = em.createQuery(select,Income.class);
		return query.getResultList();
	}
	
	
	public List<Income> findbyYear(int year){
		String select = "select i from Income i where YEAR(income_date) like "+year;
		TypedQuery<Income> query = em.createQuery(select,Income.class);
		return query.getResultList();
	}

}
