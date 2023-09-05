package com.bank.bean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Administrator extends Bank implements IAdministrator {

	    private Bank bank;

	    public Administrator(Bank bank) {
	        this.bank = bank;
	    }

	    public Customer createCustomer(String customerName, String accountType, double balance, double minBalance, String mobileNumber, String emailId) {

	    	if ( !isValidMobileNumber(mobileNumber) || !isValidCustomerName(customerName) || !isValidBalance(balance)) {
	            System.out.println("Invalid input. Please check the provided data.");
	            return null;
	        }

	        int accountNo = generateAccountNo();
	        int atmPin = generateATMPin();
	        Customer customer = new Customer(accountNo, customerName, accountType, balance, minBalance, mobileNumber, emailId, atmPin);
	        bank.addCustomer(customer);
	        return customer;
	    }
	    public boolean removeCustomer(int accountNo) {
	    	
	    	return bank.deleteCustomer(accountNo);
			
	    }
	    public boolean updateCustomer(int accountNo, String newMobileNumber, String newEmailId) {
			return bank.updateCustomerDetails(accountNo, newMobileNumber, newEmailId);
	    	
	    	
	    }

	     public boolean isValidAccountNumber(String accountNumber) {
	        // Account number should be a 9-digit number
	    	 try {
	 			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 			do {
	 			if(accountNumber.matches("\\d{9}"))
	        		break;
	 			else {
	 				System.out.println("Kindly re-enter!");
			System.out.print("Account Number : ");
			accountNumber = br.readLine();
	 				 }
	 			 	}while(true);
	 			}catch(Exception e ) {
	 				e.printStackTrace();
	 			}
	    return true;
	     }

	    public boolean isValidMobileNumber(String mobileNumber) {
	        // Mobile number should be a 10-digit number
	    	try {
	 			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 			do {
	 				if(mobileNumber.matches("\\d{10}"))
	 					break;
	 				else {
	 					System.out.println("Kindly re-enter!");
	 					System.out.print("Moblile Number : ");
	 					mobileNumber = br.readLine();
	 				}
	 			}while(true);
 			}catch(Exception e ) {
 				e.printStackTrace();
 			}
    return true;
	 				
	    }

	    public boolean isValidCustomerName(String customerName) {
	        // Customer name should not be more than 30 characters
	    	try {
	 			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 			do {
	 				if(customerName.length() <= 30)
	 					break;
	 				else {
	 					System.out.println("Kindly re-enter!");
	 					System.out.print("Customer Name : ");
	 					customerName = br.readLine();
	 				}
	 					
	 				}while(true);
	    	}catch(Exception e ) {
 				e.printStackTrace();
 			}
    return true;
	    }

	    public boolean isValidBalance(double balance) {
	        // Balance should be numeric and non-negative
	        return balance >= 0;
	    }
	    public int generateAccountNo() {
	        // Generate a 9-digit account number (you can use a random generator)
	        Random random = new Random();
	        return 100000000 + random.nextInt(900000000);
	    }

	    public int generateATMPin() {
	        // Generate a 4-digit ATM pin (you can use a random generator)
	        Random random = new Random();
	        return 1000 + random.nextInt(9000);
	    }
	}

