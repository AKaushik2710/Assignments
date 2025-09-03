package atmMachine;

interface ATMInterface{
	void withdraw(double amount);
	void deposit(double amount);
	void checkBalance();
}

class MyATMClass implements ATMInterface{
	private int accountNo;
	private double balance;
	MyATMClass(int no, double balance){
		this.accountNo = no;
		this.balance = balance;
	}
	
	public void withdraw(double amount) {
		this.balance -= amount;
		System.out.println("Amount "+amount+" has been withdrawn from account number "+this.accountNo);
	}
	
	public void deposit(double amount) {
		this.balance += amount;
		System.out.println("Amount "+amount+" has been deposited in account number "+this.accountNo);
	}
	
	public void checkBalance() {
		System.out.println("Account "+this.accountNo + " has a balance of "+this.balance);
	}
}
