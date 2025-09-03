package bankAccountSystem;

public class FixedDepositAccount extends BankAccount{
	FixedDepositAccount(int no, double balance){
		super(no, balance);
	}
	void calculateInterest() {
		double finalAmount = this.balance + this.balance*0.07;
		System.out.println("Balance after adding interest is "+finalAmount);
	}
}
