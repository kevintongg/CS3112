package hello;

class Hello {

  public static void main(String[] args) {

    Integer[] list = {1, 4, 2, 7, 5};

    System.out.println("Before");
    for (Integer i : list) {
      System.out.println(i);
    }

    quickSort(list);

    System.out.println("After");
    for (Integer i : list) {
      System.out.println(i);
    }

  }

  private static void insertionSort(int[] list) {

    for (int i = 1; i < list.length; i++) {
      int temp = list[i];
      int j;
      for (j = i - 1; j >= 0 && list[j] > temp; j--) {
        list[j + 1] = list[j];
      }
      list[j + 1] = temp;
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
}
