package lab6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int choice;
    do {
      System.out.println("\nPlease pick a program to run:");
      System.out.println("1. Heap Sort");
      System.out.println("2. O(nlogk) algorithm");
      System.out.println("Enter 0 to quit.");
      while (!sc.hasNextInt()) {
        sc.nextLine();
      }
      choice = sc.nextInt();
      switch (choice) {
        case 1:
          Random random = new Random();
          Integer[] integers = new Integer[10];
          for (int i = 0; i < integers.length; i++) {
            integers[i] = random.nextInt(20) - 10;
          }

          System.out.println("Array before heap sort");
          printArray(integers);
          System.out.println("\nNow sorting...");
          try {
            Thread.sleep(1500);
          } catch (InterruptedException e) {
            System.err.format("InterruptedException: %s%n", e);
          }
          heapSort(integers);
          System.out.println("\nArray after heap sort");
          printArray(integers);
          break;
        case 2:
          mergeKSortedLists();
          break;
      }
      if (choice < 0 || choice > 2) {
        System.out.println("Invalid input!");
        System.out.println("Please pick a program to run:");
        System.out.println("1. Heap Sort");
        System.out.println("2. O(nlogk) algorithm");
        System.out.println("Enter 0 to quit.");
      }
      if (choice == 0) {
        System.out.println("Have a nice day!");
      }
    } while (choice != 0);
  }

  private static <E extends Comparable<E>> void heapSort(E[] list) {

    // Create a heap
    Heap<E> heap = new Heap<>();

    // Add elements to the heap
    for (E e : list) {
      heap.add(e);
    }

    // Remove items from the index
    for (int i = list.length - 1; i >= 0; i--) {
      list[i] = heap.remove();
    }
  }

  private static void mergeKSortedLists() {

    int[][] array = new int[4][];

    array[0] = new int[]{3, 5, 12, 15};
    array[1] = new int[]{6, 10, 16, 19};
    array[2] = new int[]{2, 9, 11, 22};
    array[3] = new int[]{4, 14, 20, 24};

    System.out.println("We will have four arrays from the board.");
    System.out.println("Array 1: " + Arrays.toString(array[0]));
    System.out.println("Array 2: " + Arrays.toString(array[1]));
    System.out.println("Array 3: " + Arrays.toString(array[2]));
    System.out.println("Array 4: " + Arrays.toString(array[3]));

    System.out.println("\nWe will now merge these four arrays.\n");

    System.out.println("Now merging...");

    try {
      Thread.sleep(1500);
    } catch (InterruptedException e) {
      System.err.format("InterruptedException: %s%n", e);
    }

    MergeKSortedLists mergeKSortedLists = new MergeKSortedLists(array.length);
    int result[] = mergeKSortedLists.mergeLists(array, array.length, array[0].length);
    System.out.println("\nResult: " + Arrays.toString(result));

  }

  private static <E extends Comparable<E>> void printArray(E[] list) {

    for (E e : list) {
      System.out.print(e + " ");
    }
    System.out.println();
  }
}
