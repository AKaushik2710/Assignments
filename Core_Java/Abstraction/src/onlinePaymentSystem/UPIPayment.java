package onlinePaymentSystem;

public class UPIPayment implements Payment{
	int transactionId, accountNumber;
	UPIPayment(int id, int no){
		this.transactionId = id;
		this.accountNumber = no;
	}
	
	public void processPayment(double amount) {
		System.out.println("Your account "+this.accountNumber+" has been debited with an amount of "+amount+" having Transaction Id "+this.transactionId);
	}
	
	public void refund(double amount) {
		System.out.println("Your account "+this.accountNumber+" has been credited with an amount of "+amount);
	}
}
