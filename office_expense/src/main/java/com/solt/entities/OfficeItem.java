package com.solt.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: OfficeItem
 *
 */
@Entity

public class OfficeItem implements Serializable {

	public enum CATEGORY{
		LAPTOP , FURNITURE, ELECTRONIC
	}
	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date item_date;
	private String name;
	@Enumerated
	private CATEGORY category;
	private int quantity;
	private static final long serialVersionUID = 1L;

	public OfficeItem() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public Date getItem_date() {
		return this.item_date;
	}

	public void setItem_date(Date item_date) {
		this.item_date = item_date;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CATEGORY getCategory() {
		return category;
	}
	public void setCategory(CATEGORY category) {
		this.category = category;
	}
	
}
