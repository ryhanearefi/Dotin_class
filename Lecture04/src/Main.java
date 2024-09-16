import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        int a = 20;
//        short b = 30;
//        long c = 40333333;
//        float d = 50;
//        double e = 60.2;
//        boolean f = true;
//        byte  w = 'a';
//        char ch = 'c';
//
//        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.println(String.valueOf(a));
//        System.out.println(String.valueOf(b));
//        System.out.println(String.valueOf(c));
//        System.out.println(String.valueOf(d));
//        System.out.println(String.valueOf(e));
//        System.out.println(String.valueOf(f));
//        System.out.println(String.valueOf(w));
////        System.out.println(String.valueOf(ch));
//        Scanner scanner = new Scanner(System.in);
//
//        // Prompt the user to enter a number
//        System.out.print("Enter a number: ");
//        double number = scanner.nextDouble();
//
//        // Calculate the square of the number
//        double number1 = number * number;
//
//        // Display the result
//        System.out.println(" Number " + number + " is " + number1);
//
//        scanner.close();

//        int number =2;
//        number+=5;
//        number-=3;
//        number*=10;
//        number/=2;
//        number%=10;
//
//
//        System.out.println(number);
//
//        int a = 20;
//        int b = 10;
//        int c = 12;
//
//        int delta = (b * b) - (4 * (a * c));
//        System.out.println(a>b || b<c);
//        System.out.println(delta);
//        int age=16;
//        if(age>18){
//            System.out.println("Mitavanid Ray Dahid");
//
//        }
//        else {
//            System.out.println("Nemitavanid Ray Dahid");
//        }
//ctrl+alt+m  برای تولید یک متد
//        Dayofweek();
//    }
//
//    private static void Dayofweek() {
//        int day=8;
//        if(day==1){
//            System.out.println("شنبه");
//        }
//        else if(day==2){
//            System.out.println("یک شنبه");
//        }
//        else if(day==3){
//            System.out.println("دو شنبه");
//        }
//        else if(day==4){
//            System.out.println("سه شنبه");
//        }
//        else if(day==5){
//            System.out.println("چهار شنبه");
//        }
//        else if(day==6){
//            System.out.println("پنج شنبه");
//        }
//        else if(day==7){
//            System.out.println("جمعه");
//        }
//        else {
//            System.out.println("Out of day");
//        }

//
//        int number=3;
//        if (number%2==0){
//            System.out.println("Number is even");
//        }  else if (number%2==1){
//            System.out.println("Number is odd");
//        }

        int day = 2;
        switch (day) {
            case 1:
                System.out.println("شنبه");
                break;
            case 2:
                System.out.println("یک شنبه");
                break;
            case 3:
                System.out.println(" دو شنبه");
                break;
            case 4:
                System.out.println("سه شنبه");
                break;
            case 5:
                System.out.println("چهار شنبه");
                break;
            case 6:
                System.out.println("پنج شنبه");
                break;
            case 7:
                System.out.println("جمعه");
                break;
            default:
                System.out.println("Out Of Day Week");
        }
    }
}