package assignment1;

import java.util.Scanner;

public class PrimeNumber {

  public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);
    int n;
    int status = 1;
    int num = 3;
    System.out.println("Enter the value of n:");
    n = sc.nextInt();

    if (n >= 1) {
      System.out.println("First " + n + " prime numbers are:");
      //2 is a known assignment1 number
      System.out.println(2);
    }

    for (int i = 2; i <= n; ) {
      for (int j = 2; j <= Math.sqrt(num); j++) {
        if (num % j == 0) {
          status = 0;
          break;
        }
      }
      if (status != 0) {
        System.out.println(num);
        i++;
      }
      status = 1;
      num++;
    }
  }

}


