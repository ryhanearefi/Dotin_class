public  class LongTermDeposit extends Deposit {
    private static final double ANNUAL_INTEREST_RATE = 0.20;

    public LongTermDeposit(String ownerName, double balance) {
        super(ownerName, balance);
    }

    @Override
    public void deposit(double amount) {
        System.out.println("واریز به سپرده بلند مدت ممکن نیست.");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("برداشت از سپرده بلند مدت ممکن نیست.");
    }

    @Override
    public double calculateMonthlyInterest() {
        return balance * ANNUAL_INTEREST_RATE / 12;
    }
}