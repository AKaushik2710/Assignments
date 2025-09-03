package atmMachine;

public class ATM {
	public static void main(String[] args) {
		MyATMClass t = new MyATMClass(1001, 43507.88);
		t.checkBalance();
		t.deposit(23435.5);
		t.checkBalance();
		t.withdraw(34234.35);
		t.checkBalance();
	}
}
