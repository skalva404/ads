package kalva.learnings.ads.arrays.general;

import java.util.Arrays;

/**
 * Given an unsorted array of integreaterrs.
 * Find an element such that all the elements to its left are smaller and to its right are greater.
 * Print -1 if no such element exists.
 * http://www.geeksforgeeks.org/find-the-element-before-which-all-the-elements-are-smaller-than-it-and-after-which-all-are-greater-than-it/
 */
public class PartitionPoint {

  public static void main(String[] args) {
    Integer input[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};
    System.out.println(input[FindElement(input)]);
  }

  static int FindElement(Integer input[]) {

    Integer leftToRight[] = new Integer[input.length];
    leftToRight[0] = 0;
    for (int i = 1; i < input.length; i++) {
      leftToRight[i] = Math.max(leftToRight[i - 1], input[i - 1]);
    }

    System.out.println(Arrays.asList(input));
    System.out.println(Arrays.asList(leftToRight));

    int rightMin = Integer.MAX_VALUE;
    for (int i = input.length - 1; i >= 0; i--) {
      if (leftToRight[i] < input[i] && rightMin > input[i]) {
        return i;
      }
      rightMin = Math.min(rightMin, input[i]);
    }
    return -1;
  }
}

