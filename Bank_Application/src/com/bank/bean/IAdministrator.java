package com.bank.bean;

public interface IAdministrator {

	public Customer createCustomer(String customerName, String accountType, double balance, double minBalance, String mobileNumber, String emailId);
	boolean isValidAccountNumber(String accountNumber);
	boolean isValidMobileNumber(String mobileNumber);
	boolean isValidCustomerName(String customerName);
	public boolean isValidBalance(double balance);
	public boolean removeCustomer(int accountNo);
	
	
}
