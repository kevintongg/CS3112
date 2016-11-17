package assignment8;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Main {

  private static final Scanner SC = new Scanner(System.in);
  private static final Random RANDOM = new Random();

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int choice;
    do {
      System.out.println("\nPlease pick a program to run:");
      System.out.println("1. Randomized Quick Sort");
      System.out.println("2. Counting Sort");
      System.out.println("3. Radix Sort");
      System.out.println("Enter 0 to quit.");
      while (!sc.hasNextInt()) {
        sc.nextLine();
      }
      choice = sc.nextInt();
      switch (choice) {
        case 1:
          Integer[] list = new Integer[10];

          for (int i = 0; i < list.length; i++) {
            list[i] = RANDOM.nextInt(24) - 12;
          }

          printArray(list);
          quickSort(list);
          printArray(list);
          break;
        case 2:
          System.out.println("Please input your n:");
          int n = SC.nextInt();

          int[] array = new int[n + 1];

          System.out.println("Please enter a k:");
          int k = SC.nextInt();

          for (int i = 1; i < array.length; i++) {
            array[i] = RANDOM.nextInt(k + 1);
          }

          System.out.println(Arrays.toString(array));
          System.out.println(Arrays.toString((countingSort(array,n,k))));
          break;
        case 3:
          System.out.println("Please input your n:");

          int[] a = new int[10];

          for (int i = 0; i < a.length; i++) {
            a[i] = RANDOM.nextInt(24) - 12;
          }

          System.out.println(Arrays.toString(a));
          radixSort(a);
          System.out.println(Arrays.toString(a));

          break;
      }
      if (choice < 0 || choice > 3) {
        System.out.println("Invalid input!");
        System.out.println("Please pick a program to run:");
        System.out.println("1. Randomized Quick Sort");
        System.out.println("2. Counting Sort");
        System.out.println("3. Radix Sort");
        System.out.println("Enter 0 to quit.");
      }
      if (choice == 0) {
        System.out.println("Have a nice day!");
      }
    } while (choice != 0);


//    Integer[] list = {2, 1, 3, 4};
//
//    System.out.println(Arrays.toString(list));
//
//    randomizedQuickSort(list);
//
//    System.out.println(Arrays.toString(list));

  }

  private static int[] countingSort(int[] A, int n, int k) {
    int[] C = new int[k + 1];

    for (int i = 0; i <= k; i++) {
      C[i] = 0;
    }
    for (int j = 1; j <= n; j++) {
      C[A[j]] = C[A[j]] + 1;
    }
    for (int i = 1; i <= k; i++) {
      C[i] = C[i] + C[i - 1];
    }

    int[] B = new int[n + 1];

    for (int j = n; j >= 1; j--) {
      B[C[A[j]]] = A[j];
      C[A[j]] = C[A[j]] - 1;
    }

    return B;
  }

  static void radixSort(int[] a) {
    int i, m = a[0], exp = 1, n = a.length;
    int[] b = new int[10];
    for (i = 1; i < n; i++)
      if (a[i] > m)
        m = a[i];
    while (m / exp > 0) {
      int[] bucket = new int[10];

      for (i = 0; i < n; i++)
        bucket[(a[i] / exp) % 10]++;
      for (i = 1; i < 10; i++)
        bucket[i] += bucket[i - 1];
      for (i = n - 1; i >= 0; i--)
        b[--bucket[(a[i] / exp) % 10]] = a[i];
      for (i = 0; i < n; i++)
        a[i] = b[i];
      exp *= 10;
    }

  }

  private static <E extends Comparable<E>> void quickSort(E[] list) {
    quickSort(list, 0, list.length - 1);
  }

  private static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) {

    if (first < last) {
      int pivotIndex = partition(list, first, last);
      quickSort(list, first, pivotIndex - 1);
      quickSort(list, pivotIndex + 1, last);
    }
  }

  private static <E extends Comparable<E>> int partition(E[] list, int first, int last) {

    E pivot = list[first];
    int low = first + 1;
    int high = last;

    while (high > low) {
      while (low <= high && list[low].compareTo(pivot) <= 0) {
        low++;
      }
      while (low <= high && list[high].compareTo(pivot) > 0) {
        high--;
      }
      if (high > low) {
        E temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }

    while (high > first && list[high].compareTo(pivot) >= 0) {
      high--;
    }

    if (pivot.compareTo(list[high]) > 0) {
      list[first] = list[high];
      list[high] = pivot;
      return high;
    } else {
      return first;
    }
  }

  private static <E extends Comparable<E>> void printArray(E[] list) {

    System.out.println(Arrays.toString(list));
  }

}
