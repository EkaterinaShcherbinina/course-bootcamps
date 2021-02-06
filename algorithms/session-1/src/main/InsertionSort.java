package main;

public class InsertionSort {
    public static void main(String[] args) {
        Integer[] array = {33, 6, 1, 0, 8, 9, 3, 4, 26, 2, 14};
        insertionSort(array);
        for(int n: array) {
            System.out.print(n + ", ");
        }
    }

    public static void insertionSort(Comparable[] array) {
        for(int i = 1; i < array.length; i++) {
            for(int j = i; j > 0; j--) {
                if(less(array[j], array[j - 1])) swap(j, j - 1, array);
                else break;
            }
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void swap(int a, int b, Comparable[] array) {
        Comparable temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
