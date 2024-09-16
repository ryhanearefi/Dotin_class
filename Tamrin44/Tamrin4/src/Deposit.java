public abstract class Deposit {
    protected String ownerName;
    protected double balance;

    public Deposit(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public abstract double calculateMonthlyInterest();
}