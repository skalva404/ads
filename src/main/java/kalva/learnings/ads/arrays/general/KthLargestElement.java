package kalva.learnings.ads.arrays.general;

import java.util.Arrays;

import kalva.learnings.ads.sort.QuickSort;

/**
 * https://www.baeldung.com/java-kth-largest-element
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/array/KthElementInArray.java
 */

public class KthLargestElement {

  public static void main(String[] args) {
    int[] array = new int[]{7, 9, 10, 2, 1, 6, 8, 5, 3, 4};
    System.out.println(findKthElementByQuickSelect(array, 0, array.length - 1, 6));
    QuickSort.quickSort(array, 0, array.length - 1);
    System.out.println(Arrays.toString(array));
  }

  private static int findKthElementByQuickSelect(int[] array, int s, int e, int k) {
    if (s >= e) {
      return -1;
    }
    int partition = QuickSort.partition(array, s, e);
    if (partition + 1 == k) {
      return array[partition];
    }
    if (partition + 1 > k) {
      return findKthElementByQuickSelect(array, s, partition - 1, k);
    }
    return findKthElementByQuickSelect(array, partition + 1, e, k);
  }
}
