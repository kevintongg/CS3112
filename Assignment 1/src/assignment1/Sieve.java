package assignment1;

import java.util.Scanner;

public class Sieve {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int n;

    System.out.println("Enter a positive number to sieve:");
    n = sc.nextInt();
  }

  private static int sieve(int n) {

    boolean[] primes = new boolean[n];
    double j;
    int count = 1;

    for (int p = 2; p < n; p++) {
      primes[n] = true;
    }
    for (int p = 2; p < Math.sqrt(n); p++) {
      if (primes[n]) {
        j = Math.pow(p, 2);
      }
    }

    return count;
  }
}
