package lab5;

import java.util.Random;

public class MaximumSubarray {

  private int low = 0;
  private int high = 0;
  private int sum = 0;

  public MaximumSubarray(int low, int high, int sum) {
    this.low = low;
    this.high = high;
    this.sum = sum;
  }

  static MaximumSubarray bruteForce(int[] array, int low, int high) {

    int left = 0;
    int right = 0;
    int sum = 0;
    int maxSum = Integer.MIN_VALUE;

    for (int i = low; i <= high; i++) {
      sum = 0;
      for (int j = i; j <= high; j++) {
        sum += array[j];
        if (sum > maxSum) {
          maxSum = sum;
          left = i;
          right = j;
        }
      }
    }

    return new MaximumSubarray(left, right, maxSum);

  }
}

