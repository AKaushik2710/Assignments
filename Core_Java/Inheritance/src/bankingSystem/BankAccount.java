package bankingSystem;

public class BankAccount {
	int accountNumber;
	double balance;
	String holderName;
	BankAccount(int no, double balance, String name){
		this.accountNumber = no;
		this.balance = balance;
		this.holderName = name;
	}
	
	void deposit(double amount) {
		this.balance += amount;
	}
	
	void withdrawal(double amount) {
		this.balance -= amount;
	}
}
