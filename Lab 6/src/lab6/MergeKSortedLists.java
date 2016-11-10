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
      HeapNode node = extractMin(); // get min
      result[count] = node.data;
      pointers[node.listNum]++;
      if (pointers[node.listNum] < n) {
        insert(array[node.listNum][pointers[node.listNum]], node.listNum); // insert next element in list
      } else {
        insert(Integer.MAX_VALUE, node.listNum); // if no more, put positive infinity
      }
      count++;
    }
    return result;
  }


  private void insert(int data, int listNum) {
    if (position == 0) { // is heap empty?
      heap[position + 1] = new HeapNode(data, listNum); // insert the first element in heap
      position = 2;
    } else {
      heap[position++] = new HeapNode(data, listNum);// insert the element to the end
      bubbleUp();
    }
  }

  private void bubbleUp() {
    int position = this.position - 1; // get the last position
    while (position > 0 && heap[position / 2].data > heap[position].data) { // is the parent greater?
      HeapNode node = heap[position]; // if so, swap it
      heap[position] = heap[position / 2];
      heap[position / 2] = node;
      position = position / 2; // make position to the parent for next round
    }
  }

  private HeapNode extractMin() {
    HeapNode min = heap[1]; // get the root
    heap[1] = heap[position - 1]; // replace root with the last element in the heap
    heap[position - 1] = null; // set the last node as null
    position--; // reduce the position pointer
    sinkDown(1); // sink down root to its correct position
    return min;
  }

  private void sinkDown(int k) {
    int smallest = k;
    if (2 * k < position && heap[smallest].data > heap[2 * k].data) {
      smallest = 2 * k;
    }
    if (2 * k + 1 < position && heap[smallest].data > heap[2 * k + 1].data) {
      smallest = 2 * k + 1;
    }
    if (smallest != k) {
      swap(k, smallest);
      sinkDown(smallest);
    }
  }

  private void swap(int a, int b) {
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