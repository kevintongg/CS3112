package lab1;

import java.util.Scanner;

public class PrimeFactorization {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int n;
    int counter;

    System.out.println("Enter a positive number for your prime factorization:");
    n = sc.nextInt();

    for (int i = 2; i <= n; i++) {
      counter = 0;
      while (n % i == 0) {
        n /= i;
        counter++;
      }
      if (counter != 0) {
        System.out.println(i + "^" + counter);
      }
    }
  }
}