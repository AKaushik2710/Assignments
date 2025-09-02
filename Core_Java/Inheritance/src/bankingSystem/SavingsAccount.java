package bankingSystem;

public class SavingsAccount extends BankAccount {
	public SavingsAccount(int no, double balance, String name) {
		super(no, balance, name);
	}
	
	void addInterest(double rate) {
		double finalBalance = this.balance+(this.balance*rate/100);
		this.balance+=this.balance*(rate/100);
		System.out.println("Balance after adding interest is "+finalBalance);
	}
}
