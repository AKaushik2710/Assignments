package bankAccountSystem;

public class SavingsAccount extends BankAccount{
	SavingsAccount(int no, double balance){
		super(no, balance);
	}
	
	void calculateInterest() {
		double finalAmount = this.balance + this.balance*0.04;
		System.out.println("Balance after adding interest is "+finalAmount);
	}
}
