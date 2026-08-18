package encapsulation;

public class Account {

    private final int accountNumber;
    private String name;
    private double balance;

    public Account(int accountNumber, String name, double initial) {
        this.accountNumber = accountNumber;
        this.name = name;
        deposit(initial);

    }

    public Account(int accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;

    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double value) {
        balance += value;

    }

    public void withdraw(double value) {
        balance -= value + 5.0;

    }

    public String toString() {
        return "Account " +
                accountNumber
                + ", Holder: "
                + name
                + ", Balance: $"
                + balance;

    }
}
