package com.solt.converter;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.solt.entities.OfficeItem.CATEGORY;

@Named
@RequestScoped
public class OfficeItemCategoryConverter implements Converter {

	@Inject
	private List<CATEGORY> officeItemCategory;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(null != value) {
			for (CATEGORY category : officeItemCategory) {
				if(category.toString().equals(value)) {
					return category;
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(null != value) {
			CATEGORY c = (CATEGORY) value;
			return c.toString();
		}
		return null;
	}

}
