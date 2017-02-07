package com.solt.producer;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.solt.entities.Expense.EXPENSECATEGORY;
import com.solt.entities.Home.CATEGORY;
import com.solt.entities.Income.CLASSTYPE;


@ApplicationScoped
public class CategoryProducer {
	@Named
	@Produces
	private List<CATEGORY> homeCategory = Arrays.asList(CATEGORY.values());
	
	@Named
	@Produces
	private List<CLASSTYPE> incomeCategory = Arrays.asList(CLASSTYPE.values());

	@Named
	@Produces
	private List<EXPENSECATEGORY> expenseCategory = Arrays.asList(EXPENSECATEGORY.values());
	
	@Named
	@Produces
	private List<com.solt.entities.OfficeItem.CATEGORY> officeItemCategory = Arrays.asList(com.solt.entities.OfficeItem.CATEGORY.values());


}
