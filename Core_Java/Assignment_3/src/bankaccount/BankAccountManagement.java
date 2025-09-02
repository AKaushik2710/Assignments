package bankaccount;

public class BankAccountManagement {
	int accountNumber;
	String holderName;
	float balance;
	
	BankAccountManagement(int accountNumber, String holderName, float balance){
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.balance = balance;
	}
	public void deposit(int depositAmount) {
		this.balance += depositAmount;
		System.out.println("You've deposited"+depositAmount+"Rs. in your account"+this.accountNumber);
	}
	
	public void withdraw(int withdrawAmount) {
		if(this.balance > withdrawAmount) {
			this.balance -= withdrawAmount;
			System.out.println("Rs."+withdrawAmount+" has been withdrawn from your bank account no. "+this.accountNumber);
		}
		else {
			System.out.println("Account does not have required balance.");
		}
	}
	
	public float balance() {
		return this.balance;
	}
}
