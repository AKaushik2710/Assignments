package bankingSystem;

public class CurrentAccount extends BankAccount{
	CurrentAccount(int no, double balance, String name){
		super(no, balance, name);
	}
	
	void applyServiceCharge(double charge) {
		this.balance-=charge;
		System.out.println("Balance after service charge is "+this.balance);
	}
}
