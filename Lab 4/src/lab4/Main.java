package lab4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

  private static final Random RANDOM = new Random();
  private static final Scanner SC = new Scanner(System.in);

  public static void main(String[] args) {

    int choice;

    do {
      System.out.println("\nPlease pick a program to run:");
      System.out.println("1. Merge Sort");
      System.out.println("2. Binary Search");
      System.out.println("3. a^n execution using divide and conquer");
      System.out.println("Enter 0 to quit.");
      while (!SC.hasNextInt()) {
        SC.nextLine();

      }
      choice = SC.nextInt();
      switch (choice) {
        case 1:
          mergeSortExecution();
          break;
        case 2:
          binarySearchExecution();
          break;
        case 3:
          long a, n;

          System.out.println("Here we will compute a^n where 'a' and 'n' are positive integers.");

          System.out.println("Please enter a value for a: ");
          a = SC.nextLong();
          System.out.println("Please enter a value for n: ");
          n = SC.nextLong();

          System.out.println("For your value of a = " + a + " and n = " + n + " your computation of a^n is: " + pow(a, n));
          break;
      }
      if (choice < 0 || choice > 3) {
        System.out.println("Invalid input!");
        System.out.println("Please pick a program to run:");
        System.out.println("1. Merge Sort");
        System.out.println("2. Binary Search");
        System.out.println("3. a^n execution using divide and conquer");
        System.out.println("Enter 0 to quit.");
      }
      if (choice == 0) {
        System.out.println("Have a nice day!");
      }
    } while (choice != 0);

  }

  private static void mergeSortExecution() {

    final int ARRAY_SIZE = 15;

    Integer[] list = new Integer[ARRAY_SIZE];

    for (int i = 0; i < ARRAY_SIZE; i++) {
      list[i] = RANDOM.nextInt(123);
    }

    mergeSort(list);

    for (Integer i : list) {
      System.out.print(i + " ");
    }
  }

  private static void binarySearchExecution() {

    final int ARRAY_SIZE = 15;
    int num;

    int[] list = {100, 103, 112, 96, 63, 116, 90, 49, 77, 122, 17, 67, 36, 33, 58};

    for (int i = 0; i < ARRAY_SIZE; i++) {
      list[i] = RANDOM.nextInt(123);
    }

    Arrays.sort(list);

    System.out.println("Your list of numbers are:");

    for (int i : list) {
      System.out.print(i + " ");
    }

    System.out.println("\nPlease choose a number to search for from the above list.");
    num = SC.nextInt();

    if (exists(list, num)) {
      System.out.println("The number you have chosen exists and the index for your value is: " + binarySearch(list, num) + ".");
    } else {
      System.out.println("Sorry! Your number does not exist!");
    }
  }

  private static long pow(long a, long n) {

    if (n == 0) {
      return 1;
    } else if (n % 2 == 0 || n == 0) {
      return pow(a, (n / 2)) * pow(a, (n / 2));
    } else if (n % 2 != 0 || n == 0) {
      return pow(a, (n - 1) / 2) * pow(a, (n - 1) / 2) * a;
    }
    return 0;
  }

  @SuppressWarnings("unchecked")
  private static <E extends Comparable<E>> void mergeSort(E[] list) {

    if (list.length > 1) {
      E[] firstHalf = (E[]) new Comparable[list.length / 2];
      System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
      mergeSort(firstHalf);

      int secondHalfLength = list.length - list.length / 2;
      E[] secondHalf = (E[]) new Comparable[secondHalfLength];
      System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
      mergeSort(secondHalf);

      merge(firstHalf, secondHalf, list);
    }
  }

  private static <E extends Comparable<E>> void merge(E[] list1, E[] list2, E[] temp) {

    int current1 = 0; // Current list1 index
    int current2 = 0; // Current list2 index
    int current3 = 0; // Current temp index

    while (current1 < list1.length && current2 < list2.length) {
      if (list1[current1].compareTo(list2[current2]) < 1) {
        temp[current3++] = list1[current1++];
      } else {
        temp[current3++] = list2[current2++];
      }
    }

    while (current1 < list1.length) {
      temp[current3++] = list1[current1++];
    }

    while (current2 < list2.length) {
      temp[current3++] = list2[current2++];
    }
  }

  public static int binarySearch(int[] list, int key) {
    return binarySearch(list, key, 0, list.length);
  }

  public static int binarySearch(int[] list, int key, int low, int high) {

    if (low > high) {
      return -1;
    }
    int mid = (low + high) / 2;
    if (key < list[mid]) {
      return binarySearch(list, key, low, mid - 1);
    } else if (key == list[mid]) {
      return mid;
    } else {
      return binarySearch(list, key, mid + 1, high);
    }
  }

  private static boolean exists(int[] list, int num) {

    for (int i : list) {
      if (num == i) {
        return true;
      }
    }
    return false;
  }
}
