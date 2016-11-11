package lab6;

import java.util.ArrayList;
import java.util.List;

public class Heap<E extends Comparable<E>> {

  private List<E> list = new ArrayList<>();

  /**
   * Create a default heap
   */
  Heap() {
  }

  /**
   * Create a heap from an array of objects
   */
  public Heap(E[] objects) {
    for (E object : objects) {
      add(object);
    }
  }

  /**
   * Add a new object into the heap
   */
  void add(E newObject) {

    // Append to the heap
    list.add(newObject);
    // The index of last NODE
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
  E remove() {

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