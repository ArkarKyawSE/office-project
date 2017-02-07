package com.solt.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.solt.dao.BankDao;
import com.solt.entities.Bank;

@Named
@RequestScoped
public class BankBean {
	private Bank b;
	private List<Bank> banks;
	private double totalWithdraw;
	private double totalDeposit;
	
	@Inject
	private BankDao bDao;
	
	@PostConstruct
	public void init(){
		b = new Bank();
		banks = bDao.findAll();
		totalWithdraw = banks.stream().mapToDouble(a -> a.getWithdraw()).sum();
		totalDeposit = banks.stream().mapToDouble(a -> a.getDeposit()).sum();
	}
	
	public String addStatement(){
		bDao.insert(b);
		return "/views/bankStatement?faces-redirect=true";
	}

	public Bank getB() {
		return b;
	}

	public void setB(Bank b) {
		this.b = b;
	}

	public List<Bank> getBanks() {
		return banks;
	}

	public void setBanks(List<Bank> banks) {
		this.banks = banks;
	}

	public double getTotalWithdraw() {
		return totalWithdraw;
	}

	public void setTotalWithdraw(double totalWithdraw) {
		this.totalWithdraw = totalWithdraw;
	}

	public double getTotalDeposit() {
		return totalDeposit;
	}

	public void setTotalDeposit(double totalDeposit) {
		this.totalDeposit = totalDeposit;
	}
	
	
}
