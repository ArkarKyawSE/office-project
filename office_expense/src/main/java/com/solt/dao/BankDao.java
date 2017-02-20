package com.solt.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.solt.entities.Bank;

@Local
@Stateless
public class BankDao extends AbstractDao<Bank>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BankDao() {
		super(Bank.class);
	}

}
