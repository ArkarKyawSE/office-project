package com.solt.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.solt.dao.OfficeItemDao;
import com.solt.entities.OfficeItem;

@Named
@RequestScoped
public class OfficeItemBean {
	
	List<OfficeItem> officeItems;
	OfficeItem ot;
	
	@Inject 
	private OfficeItemDao OIDao;
	
	@PostConstruct
	public void init(){
		officeItems = OIDao.findAll();
		ot = new OfficeItem();
	}

	public String addOfficeItem(){
		OIDao.insert(ot);
		return "/views/officeItem?faces-redirect=true";
	}
	
	public String removeOfficeItem(OfficeItem ot){
		OIDao.delete(ot.getId());
		//officeItems = OIDao.findAll();
		return "/views/officeItem?faces-redirect=true";
	}
	
	public void increaseItem(OfficeItem ot){
		ot.setQuantity(ot.getQuantity()+1);
		OIDao.update(ot);
		officeItems = OIDao.findAll();
	}
	
	public void decreaseItem(OfficeItem ot){
		ot.setQuantity(ot.getQuantity()-1);
		OIDao.update(ot);
		officeItems = OIDao.findAll();
	}

	
	public List<OfficeItem> getOfficeItems() {
		return officeItems;
	}

	public void setOfficeItems(List<OfficeItem> officeItems) {
		this.officeItems = officeItems;
	}

	public OfficeItem getOt() {
		return ot;
	}

	public void setOt(OfficeItem ot) {
		this.ot = ot;
	}
	
	
	
	
}
