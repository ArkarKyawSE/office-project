package com.solt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.solt.entities.Expense;
import com.solt.entities.Home;
import com.solt.entities.Home.CATEGORY;
import com.solt.entities.Income;

@Local
@Stateless
public class HomeDao {
	@Inject
	private IncomeDao icDao;
	@Inject
	private ExpenseDao exDao;
	
	
	private List<Income> incomes;
	private List<Expense> expenses;
	private List<Home> homes;
	
	public List<Home> findAll(){
		homes = new ArrayList<Home>();
		incomes = icDao.findAll();
		expenses = exDao.findAll();
		changeIncomeToHome();
		changeExpenseToHome();
		return homes;
	}
	
	public List<Home> findbyMonth(int year , int month){
		homes = new ArrayList<Home>();
		incomes = icDao.findbyMonth(year, month);
		expenses = exDao.findbyMonth(year, month);
		changeIncomeToHome();
		changeExpenseToHome();
		return homes;
	}
		
	public List<Home> findbyYear(int year){
		homes = new ArrayList<Home>();
		incomes = icDao.findbyYear(year);
		expenses = exDao.findbyYear(year);
		changeIncomeToHome();
		changeExpenseToHome();
		return homes;
	}
	
	private void changeIncomeToHome(){
		for(Income icome:incomes){
			Home home = new Home();
			home.setDate(icome.getIncome_date());
			switch (icome.getClassType()){
			case JAVASE :
				home.setCategory(CATEGORY.JAVASE);
				break;
			case JAVAEE:
				home.setCategory(CATEGORY.JAVAEE);
				break;
			case JAVAWEB:
				home.setCategory(CATEGORY.JAVAWEB);
				break;
			case ONESTOP:
				home.setCategory(CATEGORY.ONESTOP);
				break;
			default:
				home.setCategory(CATEGORY.OTHER_INCOME);
				break;
			}
			home.setIncome(icome.getAmount());
			home.setRemark(icome.getRemark());
			homes.add(home);
		}

	}
	private void changeExpenseToHome(){
		for(Expense expense : expenses){
			Home home = new Home();
			home.setDate(expense.getExpense_date());
			home.setExpense(expense.getAmount());
			home.setRemark(expense.getRemark());
			switch (expense.getExpense_category()){
			case TAX:
				home.setCategory(CATEGORY.TAX);
				break;
			case BILL:
				home.setCategory(CATEGORY.BILL);
				break;
			case MAINTAINENCE:
				home.setCategory(CATEGORY.MAINTAINENCE);
				break;
			case OFFICE_ITEM:
				home.setCategory(CATEGORY.OFFICE_ITEM);
				break;
			case PAY_ROLL:
				home.setCategory(CATEGORY.PAY_ROLL);
				break;
			case EMPLOYEE_TRAINNING:
				home.setCategory(CATEGORY.EMPLOYEE_TRAINNING);
				break;
			case ROOM_RENTAL:
				home.setCategory(CATEGORY.ROOM_RENTAL);
				break;
			case OTHER:
				home.setCategory(CATEGORY.OTHER_EXPENSE);
				break;
			}
			homes.add(home);
		}		
	}
}
