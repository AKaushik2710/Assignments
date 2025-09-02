package bankingSystem;

public class Main {
	public static void main(String[] args) {
		SavingsAccount sa = new SavingsAccount(1001, 34567.89, "User1");
		CurrentAccount ca = new CurrentAccount(1002, 5678.9, "User2");
		
		System.out.println(sa.balance);
		sa.addInterest(12.37);
		System.out.println(sa.balance);
		sa.deposit(546);
		System.out.println(sa.balance);
		ca.applyServiceCharge(12.34);
		System.out.println(ca.balance);
	}
}
