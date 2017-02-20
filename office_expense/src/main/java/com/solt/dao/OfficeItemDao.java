package com.solt.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.solt.entities.OfficeItem;

@Local
@Stateless
public class OfficeItemDao extends AbstractDao<OfficeItem>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OfficeItemDao() {
		super(OfficeItem.class);
		// TODO Auto-generated constructor stub
	}

}
