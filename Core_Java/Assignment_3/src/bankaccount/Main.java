package bankaccount;

public class Main {
	public static void main(String[] args) {
		BankAccountManagement bam = new BankAccountManagement(1002,"Kaushik",43000.78f);
		bam.deposit(5400);
		bam.withdraw(4300);
		System.out.print(bam.balance());
	}
}
