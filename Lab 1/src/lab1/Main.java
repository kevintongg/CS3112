package lab1;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        System.out.println("Please pick a program to run.");
        System.out.println("1. Output the first n primes");
        System.out.println("2. List all primes not exceeding n");
        System.out.println("3. Output the prime factorization of n");
        System.out.println("Enter 0 to quit.");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Please choose a value for n:");
                primeNumbers(sc.nextInt());
                break;
            case 2:
                System.out.println("Please choose a value for n:");
                sieve(sc.nextInt());
                break;
            case 3:
                System.out.println("Please choose a value for n:");
                primeFactorization(sc.nextInt());
                break;
        }
    }

    private static int primeNumbers(int n) {

        int counter = 1;
        int num = 3;

        if (n >= 1) {
            System.out.println("The first " + n + " prime number(s) is/are:");
            System.out.println(2);
        }

        for (int i = 2; i <= n; ) {
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    counter = 0;
                    break;
                }
            }
            if (counter != 0) {
                System.out.println(num);
                i++;
            }
            counter = 1;
            num++;
        }

        return num;
    }

    private static int sieve(int n) {

        boolean[] primes = new boolean[n];
        int count = 1;

        for (int i = 2; i < Math.sqrt(n); i++) {
            for (int j = 2; j * i < n; j++) {
                if (!primes[j * i]) {
                    primes[j * i] = true;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (!primes[i]) {
                System.out.println(i + " ");
            }
        }

        return count;
    }

    private static int primeFactorization(int n) {

        int counter;

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

        return n;
    }
}
