package com.solt.converter;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.solt.entities.Expense.EXPENSECATEGORY;

@Named
@RequestScoped
public class ExpenseCategoryConverter implements Converter {

	@Inject
	private List<EXPENSECATEGORY> expenseCategory;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		if(null != value) {
			for (EXPENSECATEGORY category : expenseCategory) {
				if(category.toString().equals(value)) {
					return category;
				}
			}
		}
		return null;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			EXPENSECATEGORY classtype = (EXPENSECATEGORY)value;
			return classtype.toString();
		}
		return null;
	}

}
