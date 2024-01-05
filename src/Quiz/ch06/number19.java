package Quiz.ch06;

public class number19 {
	private int balance;
	public static final int MIN_BALANCE = 0;
	public static final int MAX_BALANCE = 1000000;
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		if(balance < number19.MIN_BALANCE || balance > number19.MAX_BALANCE) {
			return ;
		}
		
		this.balance = balance;
	}
}
