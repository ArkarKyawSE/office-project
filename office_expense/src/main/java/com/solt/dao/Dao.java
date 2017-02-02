package com.solt.dao;

import java.util.List;

public interface Dao<T>{
	List<T> findAll();
	T findById(Object id );
	void delete(Object i);
	void insert(T t);
	void update(T t);
}
