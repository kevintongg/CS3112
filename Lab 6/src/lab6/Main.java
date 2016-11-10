package lab6;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws InterruptedException {

    Scanner sc = new Scanner(System.in);

    // Test
    Integer[] integers = {23, 3, 94, 2, 11, 9};

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
          System.out.println("Array before heap sort");
          printArray(integers);
          System.out.println("\nNow sorting...");
          Thread.sleep(1250);
          heapSort(integers);
          System.out.println("\nArray after heap sort");
          printArray(integers);
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

  private static <E extends Comparable<E>> void printArray(E[] list) {

    for (E e : list) {
      System.out.print(e + " ");
    }
    System.out.println();
  }
}
