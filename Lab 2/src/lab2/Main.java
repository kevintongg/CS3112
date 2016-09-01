package lab2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\nPlease pick a program to run:");
            System.out.println("1. Selection Sort");
            System.out.println("2. Insertion Sort");
            System.out.println("3. Trees");
            System.out.println("Enter 0 to quit.");
            while (!sc.hasNextInt()) {
                sc.nextLine();

            }
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    selectionSortArrayCreationAndExecution();
                    break;
                case 2:
                    insertionSortArrayCreationAndExecution();
                    break;
            }
            if (choice < 0 || choice > 3) {
                System.out.println("Invalid input!");
                System.out.println("Please pick a program to run:");
                System.out.println("1. Selection Sort");
                System.out.println("2. Insertion Sort");
                System.out.println("3. Trees");
                System.out.println("Enter 0 to quit.");
            }
            if (choice == 0) {
                System.out.println("Have a nice day!");
            }
        } while (choice != 0);
    }

    private static void selectionSortArrayCreationAndExecution() {

        final int ARRAY_SIZE = 10;

        int[] list = new int[ARRAY_SIZE];

        for (int i = 0; i < ARRAY_SIZE; i++) {
            list[i] = RANDOM.nextInt(1234);
        }

        System.out.println("Array before selection sort: " + Arrays.toString(list));
        selectionSort(list);
        System.out.println("Array after selection sort: " + Arrays.toString(list));

    }

    private static void insertionSortArrayCreationAndExecution() {

        final int ARRAY_SIZE = 10;

        int[] list = new int[ARRAY_SIZE];

        for (int i = 0; i < ARRAY_SIZE; i++) {
            list[i] = RANDOM.nextInt(1234);
        }

        System.out.println("Array before insertion sort: " + Arrays.toString(list));
        selectionSort(list);
        System.out.println("Array after insertion sort: " + Arrays.toString(list));

    }

    private static void selectionSort(int[] list) {

        for (int i = 0; i < list.length - 1; i++) {
            int min = list[i];
            int currentIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (min > list[j]) {
                    min = list[j];
                    currentIndex = j;
                }
            }

            if (currentIndex != i) {
                list[currentIndex] = list[i];
                list[i] = min;
            }
        }
    }

    private static void insertionSort(int[] list) {

        for (int i = 1; i < list.length; i++) {
            int current = list[i];
            int j;
            for (j = i + 1; j >= 0 && list[j] > current; j--) {
                list[j + 1] = list[j];
            }

            list[j + 1] = current;
        }

    }
}
