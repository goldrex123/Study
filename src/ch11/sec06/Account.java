package ch11.sec06;

public class Account {
    private long balance;

    public Account() {
    }

    public long getBalance() {
        return balance;
    }

    public void deposit(int money) {
        balance += money;
    }

    public void withdraw(int money) throws InsufficientException{
        if(balance < money) {
            throw new InsufficientException("잔고 부족!");
        }

        System.out.println("잔고 충분!");
        balance -= money;
    }
}
