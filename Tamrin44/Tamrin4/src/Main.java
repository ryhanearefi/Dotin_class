public class Main {
    public static void main(String[] args) {
        ShortTermDeposit shortTermDeposit = new ShortTermDeposit("علی", 5000);
        LongTermDeposit longTermDeposit = new LongTermDeposit("زهرا", 10000);
        SavingDeposit savingDeposit = new SavingDeposit("محمد", 3000);

        // تست سپرده کوتاه مدت
        shortTermDeposit.deposit(1000);
        shortTermDeposit.withdraw(4000);
        System.out.println("سود ماهانه سپرده کوتاه مدت: " + shortTermDeposit.calculateMonthlyInterest());

        // تست سپرده بلند مدت
        longTermDeposit.deposit(2000); // باید پیام خطا بدهد
        longTermDeposit.withdraw(2000); // باید پیام خطا بدهد
        System.out.println("سود ماهانه سپرده بلند مدت: " + longTermDeposit.calculateMonthlyInterest());

        // تست سپرده پس انداز
        savingDeposit.deposit(1500);
        savingDeposit.withdraw(500);
        System.out.println("سود ماهانه سپرده پس انداز: " + savingDeposit.calculateMonthlyInterest());
    }
}