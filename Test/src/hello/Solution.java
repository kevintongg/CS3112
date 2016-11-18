package hello;

import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {

    execution();

  }

  private static void execution() {

    Scanner sc = new Scanner(System.in);

    int size;
    size = sc.nextInt();

    if (size > 10) {
      size = 10;
    }

    long[] array = new long[size];

    for (int i = 0; i < array.length; i++) {
      array[i] = (int) (Math.random() * Math.pow(10, 10));
    }

    long sum = 0;

    for (long i : array) {
      sum += i;
    }

    System.out.println(sum);

  }
}