//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


            AirTrip flight1 = new AirTrip("مشهد", "IR1234", "10:30");
            System.out.println("وضعیت پرواز " + flight1.getFlightNumber() + " به " + flight1.getDestination() + ": " + flight1.getStatus());

            flight1.setStatus("Delayed", "01:30");
            System.out.println("وضعیت پرواز " + flight1.getFlightNumber() + " به " + flight1.getDestination() + " بعد از تغییر: " + flight1.getStatus());



    }
}