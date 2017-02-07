package com.solt.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.solt.entities.OfficeItem;

@Local
@Stateless
public class OfficeItemDao extends AbstractDao<OfficeItem>{

	public OfficeItemDao(Class<OfficeItem> type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

}
