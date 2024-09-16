public class SavingDeposit extends Deposit {

    public SavingDeposit(String ownerName, double balance) {
        super(ownerName, balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " تومن واریز شد. موجودی: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance < amount) {
            System.out.println("موجودی کافی نیست.");
        } else {
            balance -= amount;
            System.out.println(amount + " تومن برداشت شد. موجودی: " + balance);
        }
    }

    @Override
    public double calculateMonthlyInterest() {
        return 0; // نرخ سود صفر
    }
}