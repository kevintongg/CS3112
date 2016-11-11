package lab6;

class MergeKSortedLists {

  final private HeapNode[] HEAP;
  private int position;

  MergeKSortedLists(int k) {
    HEAP = new HeapNode[k + 1];
    position = 0;
    HEAP[0] = new HeapNode(0, -1);
  }

  int[] merge(int[][] array, int k, int n) {

    int nkProduct = n * k;
    int[] result = new int[nkProduct];
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

    while (count < nkProduct) {
      HeapNode node = extractMin(); // get min
      result[count] = node.NODE;
      pointers[node.LIST_NUM]++;
      if (pointers[node.LIST_NUM] < n) {
        insert(array[node.LIST_NUM][pointers[node.LIST_NUM]], node.LIST_NUM); // insert next element in list
      } else {
        insert(Integer.MAX_VALUE, node.LIST_NUM); // if no more, put positive infinity
      }
      count++;
    }
    return result;
  }


  private void insert(int data, int listNum) {
    if (position == 0) { // is HEAP empty?
      HEAP[position + 1] = new HeapNode(data, listNum); // if so, insert the first element in HEAP
      position = 2;
    } else {
      HEAP[position++] = new HeapNode(data, listNum);// if not, insert the element to the end
      bubbleUp();
    }
  }

  private void bubbleUp() {
    int position = this.position - 1; // get the last position
    while (position > 0 && HEAP[position / 2].NODE > HEAP[position].NODE) { // is the parent greater?
      HeapNode node = HEAP[position]; // if so, swap
      HEAP[position] = HEAP[position / 2];
      HEAP[position / 2] = node;
      position = position / 2; // make position to the parent for next time
    }
  }

  private HeapNode extractMin() {
    HeapNode min = HEAP[1]; // get the root
    HEAP[1] = HEAP[position - 1]; // replace root with the last element in the HEAP
    HEAP[position - 1] = null; // set the last NODE as null
    position--; // reduce the position pointer
    sinkDown(1); // move root down to the correct position
    return min;
  }

  private void sinkDown(int k) {
    int smallest = k;
    if (2 * k < position && HEAP[smallest].NODE > HEAP[2 * k].NODE) {
      smallest = 2 * k;
    }
    if (2 * k + 1 < position && HEAP[smallest].NODE > HEAP[2 * k + 1].NODE) {
      smallest = 2 * k + 1;
    }
    if (smallest != k) {
      swap(k, smallest);
      sinkDown(smallest);
    }
  }

  private void swap(int i, int j) {
    HeapNode temp = HEAP[i];
    HEAP[i] = HEAP[j];
    HEAP[j] = temp;
  }
}

class HeapNode {

  final int NODE;
  final int LIST_NUM;

  HeapNode(int node, int listNum) {
    this.NODE = node;
    this.LIST_NUM = listNum;
  }
}