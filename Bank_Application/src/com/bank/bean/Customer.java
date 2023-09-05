package com.bank.bean;

public class Customer extends Bank implements ICustomer{

	   private int accountNo;
	    private String customerName;
	    private String accountType;
	    private double balance;
	    private double minBalance;
	    private String mobileNumber;
	    private String emailId;
	    public int atmPin;
		public Customer(int accountNo, String customerName, String accountType, double balance, double minBalance,
				String mobileNumber, String emailId, int atmPin) {
			this.accountNo = accountNo;
			this.customerName = customerName;
			this.accountType = accountType;
			this.balance = balance;
			this.minBalance = minBalance;
			this.mobileNumber = mobileNumber;
			this.emailId = emailId;
			this.atmPin = atmPin;
		}
		@Override
		public String toString() {
			return "\n Customer [accountNo=" + accountNo + ", customerName=" + customerName + ", accountType="
					+ accountType + ", balance=" + balance + ", minBalance=" + minBalance + ", mobileNumber="
					+ mobileNumber + ", emailId=" + emailId + ", atmPin=" + atmPin + "]";
		}
		public int getAccountNo() {
			return accountNo;
		}
	    public double deposit(double amount) {
	        this.balance += amount;
	        return this.balance;
	    }

	    public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		public boolean withdraw(double amount) {
	        double availableBalance = this.balance - this.minBalance;
	        if (amount <= availableBalance) {
	            this.balance -= amount;
	            return true;
	        }
	        return false;
	    }
		public String getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public void setAccountNo(int accountNo) {
			this.accountNo = accountNo;
		}
		

		
}
