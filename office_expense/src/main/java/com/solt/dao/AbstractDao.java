package com.solt.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public abstract class AbstractDao<T> implements Dao<T> {

	private static final long serialVersionUID = 1L;
	@Inject
	protected EntityManager em;
    private Class<T> type;
    
    private static final String SELECT = "select t from %s t ";
    
	public AbstractDao(Class<T> type) {
		super();
		this.type = type;
	}

	@Override
	public void insert(T t) {
		em.persist(t);
	}
	@Override
	public void update(T t) {
		em.merge(t);
	}
	
	@Override
	public void delete(Object id) {
		T t = em.find(type, id);
		em.remove(t);
	}

	@Override
	public T findById(Object id) {
		return em.find(type, id);
	}
	
	@Override
	public List<T> findAll(){
		String sql = String.format(SELECT, type.getSimpleName());
		TypedQuery<T> query = em.createQuery(sql,type);
		return query.getResultList();
	}
}