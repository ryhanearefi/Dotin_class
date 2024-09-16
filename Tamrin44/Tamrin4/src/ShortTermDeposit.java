public class ShortTermDeposit extends Deposit {
    private static final double MIN_BALANCE = 2000;
    private static final double ANNUAL_INTEREST_RATE = 0.10;

    public ShortTermDeposit(String ownerName, double balance) {
        super(ownerName, balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " تومن واریز شد. موجودی: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount < MIN_BALANCE) {
            System.out.println("برداشت ممکن نیست. موجودی نباید کمتر از " + MIN_BALANCE + " تومن شود.");
        } else {
            balance -= amount;
            System.out.println(amount + " تومن برداشت شد. موجودی: " + balance);
        }
    }

    @Override
    public double calculateMonthlyInterest() {
        return balance * ANNUAL_INTEREST_RATE / 12;
    }
}