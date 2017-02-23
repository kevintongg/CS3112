package hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorts {

  public static void main(String[] args) {

    Integer[] array = {4, 2, 1, 5};

    System.out.println(Arrays.toString(array));
    quickSort(array);
    System.out.println(Arrays.toString(array));

  }

  private static <E extends Comparable<E>> void selectionSort(E[] list) {

    for (int i = 0; i < list.length - 1; i++) {
      int smallest = i;
      for (int j = i + 1; j < list.length; j++) {
        if (list[j].compareTo(list[smallest]) < 0) {
          smallest = j;
        }
      }
      E temp = list[smallest];
      list[smallest] = list[i];
      list[i] = temp;
    }
  }

  private static <E extends Comparable<E>> void insertionSort(E[] list) {

    for (int i = 1; i < list.length; i++) {
        /*
         *
         * Insert list[i] into a sorted sublist list[0..i-1] so
         * that list[0..i] is sorted.
         *
         */
      E currentItem = list[i];
      int j;
      for (j = i - 1; j >= 0 && currentItem.compareTo(list[j]) < 1; j--) {
        list[j + 1] = list[j];
      }
      // Insert the current element into list[j + 1]
      list[j + 1] = currentItem;
    }
  }

  private static <E extends Comparable<E>> void bubbleSort(E[] list) {

    boolean needNextPass = true;

    for (int i = 1; i < list.length && needNextPass; i++) {
      // Array may be sorted already and next pass is not needed
      needNextPass = false;
      // Perform the next pass if needed
      for (int j = 0; j < list.length - i; j++) {
        if (list[j + 1].compareTo(list[j]) < 1) {
          // Swap list[j] with list[j + 1]
          E temp = list[j];
          list[j] = list[j + 1];
          list[j + 1] = temp;

          // Next pass still needed
          needNextPass = true;
        }
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static <E extends Comparable<E>> void mergeSort(E[] list) {

    if (list.length > 1) {
      // Merge first half
      E[] firstHalf = (E[]) new Comparable[list.length / 2];
      System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
      mergeSort(firstHalf);

      // Merge second half
      int secondHalfLength = list.length - list.length / 2;
      E[] secondHalf = (E[]) new Comparable[secondHalfLength];
      System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
      mergeSort(secondHalf);

      // Merge first and second halves into the list
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

  private static <E extends Comparable<E>> void quickSort(E[] list) { // sort method
    quickSort(list, 0, list.length - 1);
  }

  private static <E extends Comparable<E>> void quickSort(E[] list, int first,
      int last) { // helper method

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

  private static <E extends Comparable<E>> void heapSort(E[] list) {

    // Create a heap of whatever data type
    Heap<E> heap = new Heap<>();

    // Add elements to the heap
    for (E i : list) {
      heap.add(i);
    }

    // Remove items from the index
    for (int i = list.length - 1; i >= 0; i--) {
      list[i] = heap.remove();
    }
  }

  private static class Heap<E extends Comparable<E>> {

    private List<E> list = new ArrayList<>();


    /**
     * Create a default heap
     */
    public Heap() {

    }

    /**
     * Create a heap from an array of objects
     */
    public Heap(E[] objects) {

      for (E o : objects) {
        add(o);
      }
    }

    /**
     * Add a new object into the heap
     */
    public void add(E newObject) {

      // Append to the heap
      list.add(newObject);
      // The index of last node
      int currentIndex = list.size() - 1;

      while (currentIndex > 0) {
        int parentIndex = (currentIndex - 1) / 2;
        // Swap if current object is greater than its parent
        if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
          E temp = list.get(currentIndex);
          list.set(currentIndex, list.get(parentIndex));
          list.set(parentIndex, temp);
        } else {
          break;
        }

        currentIndex = parentIndex;
      }
    }

    /**
     * Remove the root from the heap
     */
    public E remove() {

      if (list.size() == 0) {
        return null;
      }

      E removedObject = list.get(0);
      list.set(0, list.get(list.size() - 1));
      list.remove(list.size() - 1);

      int currentIndex = 0;
      while (currentIndex < list.size()) {
        int leftChildIndex = 2 * currentIndex + 1;
        int rightChildIndex = 2 * currentIndex + 2;

        // Find the max between two children
        if (leftChildIndex >= list.size()) {
          // The tree is a heap
          break;
        }
        int maxIndex = leftChildIndex;
        if (rightChildIndex < list.size()) {
          // Compare two children
          if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
            maxIndex = rightChildIndex;
          }
        }

        if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
          E temp = list.get(maxIndex);
          // Swap with larger child
          list.set(maxIndex, list.get(currentIndex));
          list.set(currentIndex, temp);
          currentIndex = maxIndex;
        } else {
          // The tree is a heap
          break;
        }
      }

      return removedObject;
    }

    /**
     * Get the number of nodes in the tree
     */
    public int getSize() {

      return list.size();

    }
  }
}