package bankAccountSystem;

public class Main {

	public static void main(String[] args) {
		SavingsAccount sa = new SavingsAccount(1001, 34506.78);
		FixedDepositAccount fda = new FixedDepositAccount(1002, 35456.43);
		
		sa.calculateInterest();
		fda.calculateInterest();

	}

}
