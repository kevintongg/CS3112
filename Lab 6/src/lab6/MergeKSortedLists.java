package lab6;

class MergeKSortedLists {

  final private HeapNode[] HEAP;
  private int location;

  MergeKSortedLists(int k) {
    HEAP = new HeapNode[k + 1];
    location = 0;
    HEAP[0] = new HeapNode(0, -1);
  }

  int[] mergeLists(int[][] list, int k, int n) {

    int nkProduct = n * k;
    int[] result = new int[nkProduct];
    int counter = 0;

    int[] index = new int[k];

    for (int i = 0; i < index.length; i++) {
      index[i] = 0;
    }
    for (int i = 0; i < k; i++) {
      if (index[i] < n) {
        insert(list[i][index[i]], i);
      } else {
        insert(Integer.MAX_VALUE, i);
      }
    }

    while (counter < nkProduct) {
      HeapNode min = getMin(); // get min
      result[counter] = min.NODE;
      index[min.LIST_NUM]++;
      if (index[min.LIST_NUM] < n) {
        insert(list[min.LIST_NUM][index[min.LIST_NUM]], min.LIST_NUM); // insert next element in list
      } else {
        insert(Integer.MAX_VALUE, min.LIST_NUM); // if no more, put positive infinity
      }
      counter++;
    }
    return result;
  }


  private void insert(int data, int listNum) {

    if (location == 0) { // is heap empty?
      HEAP[location + 1] = new HeapNode(data, listNum); // if so, insert the first element in heap
      location = 2;
    } else {
      HEAP[location++] = new HeapNode(data, listNum);// if not, insert the element to the end
      moveUp();
    }
  }

  private void moveUp() {

    int position = this.location - 1; // get the last node
    while (position > 0 && HEAP[position / 2].NODE > HEAP[position].NODE) { // is the parent node greater?
      HeapNode node = HEAP[position]; // if so, swap
      HEAP[position] = HEAP[position / 2];
      HEAP[position / 2] = node;
      position = position / 2; // make location at the parent node for next time
    }
  }

  private HeapNode getMin() {

    HeapNode node = HEAP[1]; // get the root
    HEAP[1] = HEAP[location - 1]; // replace root with the last element in the heap
    HEAP[location - 1] = null; // set the last node as null
    location--; // reduce the location pointer
    moveDown(1); // move root down to correct location
    return node;
  }

  private void moveDown(int k) {

    int smallest = k;
    if (2 * k < location && HEAP[smallest].NODE > HEAP[2 * k].NODE) {
      smallest = 2 * k;
    }
    if (2 * k + 1 < location && HEAP[smallest].NODE > HEAP[2 * k + 1].NODE) {
      smallest = 2 * k + 1;
    }
    if (smallest != k) {
      swap(k, smallest);
      moveDown(smallest);
    }
  }

  private void swap(int i, int j) {

    HeapNode temp = HEAP[i];
    HEAP[i] = HEAP[j];
    HEAP[j] = temp;
  }
}