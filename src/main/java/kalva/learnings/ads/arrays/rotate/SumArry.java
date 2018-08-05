package kalva.learnings.ads.arrays.rotate;

import kalva.learnings.ads.Utils;

//https://www.geeksforgeeks.org/find-maximum-value-of-sum-iarri-with-only-rotations-on-given-array-allowed/
public class SumArry {

  public static void main(String[] args) {
    rorateLeft(new int[]{4, 5, 1, 2, 3});
//    rorateLeft(new int[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9});
  }

//  static int maxSum(int[] array) {
//
//  }

  static void rorateLeft(int[] array) {
    for (int i = 0; i < array.length; i++) {
      Utils.printArray(array);
      int temp = array[array.length - 1];
      System.arraycopy(array, 0, array, 1, array.length - 1);
      array[0] = temp;
    }
  }
}
