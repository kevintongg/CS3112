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
      System.out.println(i);
    }

    System.out.println("\n" + bruteForceAlgorithm(array));
  }

  private static void divideAndConquer() {

    int[] array = new int[10];

    for (int i = 0; i < array.length; i++) {
      array[i] = RANDOM.nextInt(48) - 24;
    }

    for (int i : array) {
      System.out.println(i);
    }

//    System.out.println("\n" + MSAAlgorithm(array, 1, array.length - 1));
    System.out.println("\n" + MSAAlgorithm(array));
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

//  private static int MCSAlgorithm(int[] array, int low, int mid, int high) {
//
//    int leftSum = Integer.MIN_VALUE;
//    int sum1 = 0;
//    int maxLeft = 0;
//
//    for (int i = mid; i > low; i--) {
//      sum1 += array[i];
//      if (sum1 > leftSum) {
//        leftSum = sum1;
//        maxLeft = i;
//      }
//    }
//
//    int rightSum = Integer.MIN_VALUE;
//    int sum2 = 0;
//    int maxRight = 0;
//
//    for (int j = mid + 1; j < high; j++) {
//      sum2 += array[j];
//      if (sum2 > rightSum) {
//        rightSum = sum2;
//        maxRight = j;
//      }
//    }
//
//    return maxLeft + maxRight;
//
//  }
//
//  private static int MSAAlgorithm(int[] array, int low, int high) {
//
//    int mid;
//
//    if (high == low) {
//      return array[low];
//    } else {
//      mid = (low + high) / 2;
//      int leftLow = MSAAlgorithm(array, low, mid);
//      int leftHigh = MSAAlgorithm(array, low, mid);
//      int leftSum = MSAAlgorithm(array, low, mid);
//
//      int rightLow = MSAAlgorithm(array, mid + 1, high);
//      int rightHigh = MSAAlgorithm(array, mid + 1, high);
//      int rightSum = MSAAlgorithm(array, mid + 1, high);
//
//      int crossLow = MCSAlgorithm(array, low, mid, high);
//      int crossHigh = MCSAlgorithm(array, low, mid, high);
//      int crossSum = MCSAlgorithm(array, low, mid, high);
//
//      if (leftSum >= rightSum && leftSum >= crossSum) {
//        return leftSum;
//      } else if (rightSum >= leftSum && rightSum >= crossSum) {
//        return rightSum;
//      } else {
//        return crossSum;
//      }
//    }
//  }

  private static int MSAAlgorithm(int[] array) {

    int sum = array[0];
    int max = array[0];

    for (int i = 1; i < array.length; i++) {
      sum = Math.max(sum + array[i], array[i]);
      max = Math.max(max, sum);
    }

    return max;

  }

  private static int max(int a, int b) {
    return (a > b) ? a : b;
  }

  private static int max(int a, int b, int c) {
    return max(max(a, b), c);
  }
}