package com.solt.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.solt.entities.User;

@Local
@Stateless
public class UserDao extends AbstractDao<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDao() {
		super(User.class);
		// TODO Auto-generated constructor stub
	}

}
