package bankAccountSystem;

public class BankAccount {
	int accountNumber;
	double balance;
	
	BankAccount(int no, double balance){
		this.accountNumber = no;
		this.balance = balance;
	}
	
	void calculateInterest() {
		double finalAmount = this.balance + this.balance*0.02;
		System.out.println("Balance after adding interest is "+finalAmount);
	}
}
