package com.bank.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.bank.bean.Administrator;
import com.bank.bean.Bank;
import com.bank.bean.Customer;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static Customer customer[] = new Customer[5];
	static Bank bank = new Bank();
	static Administrator administrator = new Administrator(bank);
	static int i = 0;
	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int opt = 0;
		while (true) {
			System.out.println("Enter 1 for Administrator");
			System.out.println("Enter 2 for Customer");
			System.out.println("Enter 3 to Exit");
			//boolean validInput = false;
			while (true) {
	            System.out.println("Enter an integer:");
	            try {
				opt = scan.nextInt();
				if(opt>=1&&opt<=3) {
					break;
				}
				else {
					System.out.println("ENTER 1,2 or 3");
				}
				
			}catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter an integer.");
	            scan.nextLine();
			}}
			if (opt == 1) {
				char choice1 = 'n';
				do {
					System.out.println("ENTER 1 to ADD CUSTOMER");
					System.out.println("ENTER 2 to DELETE CUSTOMER");
					System.out.println("ENTER 3 to UPDATE CUSTOMER");
					System.out.println("ENTER 4 TO DISPLAY ALL CUSTOMERS");
					System.out.println("ENTER 5 TO SEARCH CUSTOMER");
					System.out.println("ENTER 6 TO GO BACK");
					int switchChoice = scan.nextInt();
					switch (switchChoice) {
					case 1:
						newAccount();
						break;
					case 2:
						System.out.println(bank.getAllCustomers());
						System.out.println("Enter the Account Number");
						String accno = scan.next();
						if (administrator.isValidAccountNumber(accno)) {
							if (administrator.removeCustomer(Integer.parseInt(accno))) {
								System.out.println("Account deleted");
							} else {
								System.out.println("Account does not exist");
							}
						} else
							System.out.println("Enter a valid Account number");
						break;
					case 3:
						updateAccount();
						break;
					case 4:
						System.out.println(bank.getAllCustomers());
						break;
					case 5:
						searchCustomer();
						break;
					case 6:
						continue;
					default:
						System.out.println("Invalid choice");
					}
					System.out.println("Do you wish to continue[Y/N]?");
					choice1 = scan.next().charAt(0);
				} while (choice1 == 'y' || choice1 == 'Y');
			} else if (opt == 2) {
				char choice2 = 'n';
				do {
					System.out.println("Enter the PIN");
					int pin = scan.nextInt();
					int flag=0;
					for (int i = 0; i < count; i++) {
						if (customer[i].atmPin == pin) {
							flag=1;
							System.out.println("ENTER 1 to DEPOSIT MONEY");
							System.out.println("ENTER 2 to WITHDRAW MONEY");
							System.out.println("ENTER 3 to VIEW BALANCE");
							System.out.println("ENTER 4 TO TRANSFER MONEY");
							System.out.println("ENTER 5 TO GO BACK");
							int switchChoice1 = scan.nextInt();
							switch (switchChoice1) {
							case 1:
								System.out.println("Enter the amount to be deposited");
								double amount = scan.nextDouble();
								if (amount > 50000) {
									System.out.println("Enter your PAN number");
									String pan = scan.next();
									double newBalance = customer[i].deposit(amount);
									System.out.println("NEW BALANCE " + newBalance);
								} else {
									double newBalance = customer[i].deposit(amount);
									System.out.println("NEW BALANCE " + newBalance);
								}
								break;
							case 2:
								System.out.println("Enter the amount to be withdrawn");
								amount = scan.nextDouble();
								if (customer[i].withdraw(amount)) {
									System.out.println("Amount debited");
									System.out.println("NEW BALANCE " + customer[i].getBalance());
								} else {
									System.out.println("INSUFFICIENT BALANCE");
								}
								break;
							case 3:
								System.out.println("BALANCE " + customer[i].getBalance());
								break;
							case 4:
								System.out.println("Enter the account number to which amount is to be transferred to");
								String accno = scan.next();
								if (administrator.isValidAccountNumber(accno)) {
									System.out.println("Enter the amount to be transferred");
									double transferAmount = scan.nextDouble();
									if (bank.transferMoney(customer[i].getAccountNo(), Integer.parseInt(accno),
											transferAmount)) {
										System.out.println("TRANSFER SUCCESFUL");
									} else {
										System.out.println("TRANSFER FAILED");
									}
								} else {
									System.out.println("INVALID ACCOUNT NUMBER");
								}
							case 5:
								continue;
							default:
								System.out.println("INVALID CHOICE");

							}
								
						} 
						if(flag==0) {
							System.out.println("INVALID PIN");
						}
						//else {
							//System.out.println("INVALID PIN");
						//}
					}
					System.out.println("Do you wish to continue[Y/N]?");
					choice2 = scan.next().charAt(0);
				} while (choice2 == 'y' || choice2 == 'Y');
			} else {
				return;
				}
		}

	}

	private static void searchCustomer() {
		// TODO Auto-generated method stub
		System.out.println("Enter the account number");
		String accno = scan.next();
		if (administrator.isValidAccountNumber(accno)) {
			Customer c = bank.getCustomerByAccountNo(Integer.parseInt(accno));
			if (c != null) {
				System.out.println("Customer Details :" + c);
			} else {
				System.out.println("Account number not found");
			}
		} else {
			System.out.println("Invalid Account Number");

		}
	}

	private static void updateAccount() {
		// TODO Auto-generated method stub
		System.out.println("Enter the number of the account to be updated");
		String accno = scan.next();
		if (administrator.isValidAccountNumber(accno)) {
			System.out.println("Enter the new mobile number");
			String mob = scan.next();
			System.out.println("Enter the new email ID");
			String mailId = scan.next();
			if (administrator.isValidMobileNumber(mob)) {
				administrator.updateCustomer(Integer.parseInt(accno), mob, mailId);
				System.out.println("SUCCESS");
			} else {
				System.out.println("Invalid Details");
			}
		}

	}

	private static void newAccount() {
		// TODO Auto-generated method stub
		System.out.println("Enter the name of the customer");
		String customerName = scan.next();
		System.out.println("Enter the account type");
		String accountType = scan.next();
		System.out.println("Enter the balance");
		double balance = scan.nextDouble();
		System.out.println("Enter the minimum balance");
		double minBalance = scan.nextDouble();
		System.out.println("Enter the mobile number");
		String mobileNumber = scan.next();
		System.out.println("Enter the email id");
		String emailId = scan.next();
		customer[i++] = administrator.createCustomer(customerName, accountType, balance, minBalance, mobileNumber,
				emailId);
		count++;
	}

}
