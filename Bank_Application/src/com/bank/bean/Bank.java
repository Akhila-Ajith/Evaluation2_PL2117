package com.bank.bean;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	    private List<Customer> customers;

	    public Bank() {
	        this.customers = new ArrayList<>();
	    }

	    public void addCustomer(Customer customer) {
	        customers.add(customer);
	    }

	    public boolean updateCustomerDetails(int accountNo, String newMobileNumber, String newEmailId) {
	        for (Customer customer : customers) {
	            if (customer.getAccountNo() == accountNo) {
	                customer.setMobileNumber(newMobileNumber);
	                customer.setEmailId(newEmailId);
	                return true;
	            }
	        }
	        return false;
	    }

	    public boolean deleteCustomer(int accountNo) {
	        for (Customer customer : customers) {
	            if (customer.getAccountNo() == accountNo) {
	                customers.remove(customer);
	                return true;
	            }
	        }
	        return false;
	    }

	    public List<Customer> getAllCustomers() {
	        return customers;
	    }

	    public Customer getCustomerByAccountNo(int accountNo) {
	        for (Customer customer : customers) {
	            if (customer.getAccountNo() == accountNo) {
	                return customer;
	            }
	        }
	        return null;
	    }

	    public boolean transferMoney(int fromAccountNo, int toAccountNo, double amount) {
	        Customer fromCustomer = getCustomerByAccountNo(fromAccountNo);
	        Customer toCustomer = getCustomerByAccountNo(toAccountNo);

	        if (fromCustomer != null && toCustomer != null && fromCustomer.withdraw(amount)) {
	            toCustomer.deposit(amount);
	            return true;
	        }

	        return false;
	    }
	}


