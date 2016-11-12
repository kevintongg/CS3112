package hello;

import java.util.Scanner;

public class Solution {

  public static void insertionSortPart2(int[] list) {
    // Fill up the code for the required logic here
    // Manipulate the array as required
    // The code for Input/Output is already provided

    for (int i = 1; i < list.length; i++) {
      int temp = list[i];
      int j;
      for (j = i - 1; j >= 0 && list[j] > temp; j--) {
        list[j + 1] = list[j];
      }
      list[j + 1] = temp;
      printArray(list);
    }
  }


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int s = in.nextInt();
    int[] ar = new int[s];
    for (int i = 0; i < s; i++) {
      ar[i] = in.nextInt();
    }
    insertionSortPart2(ar);
  }

  private static void printArray(int[] ar) {
    for (int n : ar) {
      System.out.print(n + " ");
    }
    System.out.println("");
  }

}
