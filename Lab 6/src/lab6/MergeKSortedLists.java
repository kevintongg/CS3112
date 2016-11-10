package lab6;

public class MergeKSortedLists {

  private int position;
  private HeapNode[] heap;

  public MergeKSortedLists(int k) {
    heap = new HeapNode[k + 1];
    position = 0;
    heap[0] = new HeapNode(0, -1);
  }

  protected int[] merge(int[][] array, int k, int n) {

    int nk = n * k;
    int[] result = new int[nk];
    int count = 0;

    int[] pointers = new int[k];

    for (int i = 0; i < pointers.length; i++) {
      pointers[i] = 0;
    }
    for (int i = 0; i < k; i++) {
      if (pointers[i] < n) {
        insert(array[i][pointers[i]], i);
      } else {
        insert(Integer.MAX_VALUE, i);
      }
    }

    while (count < nk) {
      HeapNode node = extractMin();
      result[count] = node.data;
      pointers[node.listNum]++;
      if (pointers[node.listNum] < n) {
        insert(array[node.listNum][pointers[node.listNum]], node.listNum); // insert the next element from the list
      } else {
        insert(Integer.MAX_VALUE, node.listNum); // if any of this list burns out, insert +infinity
      }
      count++;
    }
    return result;
  }


  private void insert(int data, int listNum) {
    if (position == 0) { // check if Heap is empty
      heap[position + 1] = new HeapNode(data, listNum); // insert the first element in heap
      position = 2;
    } else {
      heap[position++] = new HeapNode(data, listNum);// insert the element to the end
      bubbleUp(); // call the bubble up operation
    }
  }

  private void bubbleUp() {
    int pos = position - 1; // last position
    while (pos > 0 && heap[pos / 2].data > heap[pos].data) { // check if its parent is greater.
      HeapNode y = heap[pos]; // if yes, then swap
      heap[pos] = heap[pos / 2];
      heap[pos / 2] = y;
      pos = pos / 2; // make pos to its parent for next iteration.
    }
  }

  private HeapNode extractMin() {
    HeapNode min = heap[1]; // extract the root
    heap[1] = heap[position - 1]; // replace the root with the last element in the heap
    heap[position - 1] = null; // set the last Node as NULL
    position--; // reduce the position pointer
    sinkDown(1); // sink down the root to its correct position
    return min;
  }

  private void sinkDown(int k) {
    int smallest = k;
    // check which is smaller child , 2k or 2k+1.
    if (2 * k < position && heap[smallest].data > heap[2 * k].data) {
      smallest = 2 * k;
    }
    if (2 * k + 1 < position && heap[smallest].data > heap[2 * k + 1].data) {
      smallest = 2 * k + 1;
    }
    if (smallest != k) { // if any if the child is small, swap
      swap(k, smallest);
      sinkDown(smallest); // call recursively
    }
  }

  private void swap(int a, int b) {
    // System.out.println("swappinh" + mH[a] + " and " + mH[b]);
    HeapNode temp = heap[a];
    heap[a] = heap[b];
    heap[b] = temp;
  }
}

class HeapNode {
  int data;
  int listNum;

  HeapNode(int data, int listNum) {
    this.data = data;
    this.listNum = listNum;
  }
}