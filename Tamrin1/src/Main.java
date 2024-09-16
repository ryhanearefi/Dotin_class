package Tamrin1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        final int I = 1;
        final int V = 5;
        final int X = 10;
        final int L = 50;
        final int C = 100;
        final int D = 500;
        final int M = 1000;

        int sum=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = "XXIL";
        for (int i = 0; i < S.length(); i++) {
               switch (S.charAt(i)) {

                case 'I':
                    sum = sum + 1;
                    break;

                case 'V':
                    sum = sum + 5;
                    break;

                case 'X':
                    sum = sum + 10;
                    break;

                case 'L':
                    sum = sum + 50;
                    break;

                case 'C':
                    sum = sum + 100;
                    break;

                case 'D':
                    sum = sum + 500;
                    break;

                case 'M':
                    sum = sum + 1000;
                    break;

                default:
                    System.out.println("Invalid data");
            }

        }
        System.out.println(sum);
    }
}