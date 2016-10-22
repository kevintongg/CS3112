package lab5;

import java.util.Random;
import java.util.Scanner;

public class Main {

  private static final Random RANDOM = new Random();

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int choice;

    do {
      System.out.println("\nPlease pick a program to run:");
      System.out.println("1. Brute Force - Maximum Subarray");
      System.out.println("2. Divide and Conquer - Maximum Subarray");
      System.out.println("Enter 0 to quit.");
      while (!sc.hasNextInt()) {
        sc.nextLine();
      }
      choice = sc.nextInt();
      switch (choice) {
        case 1:
          bruteForce();
          break;
        case 2:
          divideAndConquer();
          break;
      }
      if (choice < 0 || choice > 2) {
        System.out.println("Invalid input!");
        System.out.println("Please pick a program to run:");
        System.out.println("1. Brute Force - Maximum Subarray");
        System.out.println("2. Divide and Conquer - Maximum Subarray");
        System.out.println("Enter 0 to quit.");
      }
      if (choice == 0) {
        System.out.println("Have a nice day!");
      }
    } while (choice != 0);

  }

  private static void bruteForce() {

    int[] array = new int[10];

    for (int i = 0; i < array.length; i++) {
      array[i] = RANDOM.nextInt(48) - 24;
    }

    for (int i : array) {
      System.out.print(i + " ");
    }

    System.out.println("\n" + "Max sum is: " + bruteForceAlgorithm(array));
  }

  private static void divideAndConquer() {

    int[] array = new int[10];

    for (int i = 0; i < array.length; i++) {
      array[i] = RANDOM.nextInt(48) - 24;
    }

    for (int i : array) {
      System.out.print(i + " ");
    }

    int maxSum = maximumSubarray(array, 0, array.length - 1);

    System.out.println("\n" + "Max sum is: " + maxSum);
  }

  private static int bruteForceAlgorithm(int[] array) {

    int maxSum = 0;

    for (int i = 0; i < array.length; i++) {
      int sum = 0;
      for (int j = i; j < array.length; j++) {
        sum += array[j];
        if (sum > maxSum) {
          maxSum = sum;
        }
      }
    }

    return maxSum;

  }

  private static int maxCrossingSubarray(int array[], int low, int mid, int high) {

    int sum = 0;
    int leftSum = Integer.MIN_VALUE;

    for (int i = mid; i >= low; i--) {
      sum += array[i];
      if (sum > leftSum)
        leftSum = sum;
    }

    sum = 0;
    int rightSum = Integer.MIN_VALUE;

    for (int i = mid + 1; i <= high; i++) {
      sum += array[i];
      if (sum > rightSum)
        rightSum = sum;
    }

    return leftSum + rightSum;
  }

  private static int maximumSubarray(int array[], int low, int high) {

    if (low == high)
      return array[low];

    int mid = (low + high) / 2;

    return max(maximumSubarray(array, low, mid),
        maximumSubarray(array, mid + 1, high),
        maxCrossingSubarray(array, low, mid, high));
  }

  private static int max(int a, int b) {
    return (a > b) ? a : b;
  }

  private static int max(int a, int b, int c) {
    return max(max(a, b), c);
  }
}