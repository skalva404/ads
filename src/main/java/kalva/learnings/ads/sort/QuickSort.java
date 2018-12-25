package kalva.learnings.ads.sort;

import java.util.Arrays;

public class QuickSort {

  public static void main(String[] args) {
    int[] array = new int[]{2, 3, 8, 4, 1, 7, 6, 5};
//    int[] array = new int[]{7, 9, 10, 2, 1, 6, 8, 5, 3, 4};
    quickSort(array, 0, array.length - 1);
    System.out.println(Arrays.toString(array));
  }

  public static int partition(int[] array, int start, int end) {
    int pivot = array[end];
    int index = start;
    for (int i = start; i < end; i++) {
      if (array[i] < pivot) {
        swap(array, index, i);
        index++;
      }
    }
    swap(array, index, end);
    return index;
  }

  private static void swap(int[] array, int a, int b) {
    int t = array[a];
    array[a] = array[b];
    array[b] = t;
  }

  public static void quickSort(int[] array, int start, int end) {
    if (start >= end) {
      return;
    }
    int pivot = partition(array, start, end);
    quickSort(array, start, pivot - 1);
    quickSort(array, pivot + 1, end);
  }
}
