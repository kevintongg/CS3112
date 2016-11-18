package assignment8;

import java.util.*;


public class Main {

  private static final Scanner SC = new Scanner(System.in);
  private static final Random RANDOM = new Random();

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int choice;
    do {
      System.out.println("\nPlease pick a program to run:");
      System.out.println("1. Quick Sort");
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
            list[i] = RANDOM.nextInt(23);
          }

          printArray(list);
          quickSort(list);
          printArray(list);
          break;
        case 2:
          System.out.println("Please enter the upper bound, k:");
          int k = SC.nextInt();

          System.out.println("Please input your input size, n:");
          int n = SC.nextInt();

          int[] array = new int[n + 1];

          for (int i = 1; i < array.length; i++) {
            array[i] = RANDOM.nextInt(k + 1);
          }

          System.out.println(Arrays.toString(array));
          System.out.println(Arrays.toString((countingSort(array, n, k))));
          break;
        case 3:
          int a;
          int b;
          System.out.println("Please input your array size");
          a = SC.nextInt();
          int arr[] = new int[a];
          for (b = 0; b < a; b++) {
            arr[b] = RANDOM.nextInt(a + 1);
          }
          System.out.println(Arrays.toString(arr));
          radixSort(arr);
          System.out.println(Arrays.toString(arr));
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

  @SuppressWarnings("unchecked")
  private static void radixSort(int[] A) {

    List<Integer>[] B = new ArrayList[10];
    for (int i = 0; i < B.length; i++) {
      B[i] = new ArrayList<>();
    }

    boolean needNextPass = false;
    int temp;
    int factor = 1;
    while (!needNextPass) {
      needNextPass = true;
      for (Integer i : A) {
        temp = i / factor;
        B[temp % 10].add(i);
        if (needNextPass && temp > 0) {
          needNextPass = false;
        }
      }
      int a = 0;
      for (int b = 0; b < 10; b++) {
        for (Integer i : B[b]) {
          A[a++] = i;
        }
        B[b].clear();
      }
      factor *= 10;
    }
  }

  private static <E extends Comparable<E>> void quickSort(E[] list) { // sort method
    quickSort(list, 0, list.length - 1);
  }

  private static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) { // helper method

    if (last > first) {
      int pivotIndex = partition(list, first, last);
      quickSort(list, first, pivotIndex - 1); // recursive call
      quickSort(list, pivotIndex + 1, last);
    }
  }

  private static <E extends Comparable<E>> int partition(E[] list, int first, int last) {

    E pivot = list[first]; // Choose first element as pivot
    int low = first + 1; // Index for forward search
    int high = last; // Index for backward search

    while (high > low) {
      // Search forward from left
      while (low <= high && list[low].compareTo(pivot) <= 0) {
        low++;
      }
      // Search backward from right
      while (low <= high && list[high].compareTo(pivot) > 0) {
        high--;
      }
      // Swap two elements in the list
      if (high > low) {
        E temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }

    while (high > first && list[high].compareTo(pivot) >= 0) {
      high--;
    }

    // Swap pivot with list[high]
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
