package test;

class Hello {

    public static void main(String[] args) {

        int[] list = {1, 4, 2, 7, 5};

        System.out.println("Before");
        for (Integer i : list) {
            System.out.println(i);
        }

        insertionSort(list);

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
}
