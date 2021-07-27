package kalva.learnings.ads.arrays.general;

import java.util.Arrays;
import java.util.HashSet;

import kalva.learnings.ads.Utils;

/**
 * https://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-
 * determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
 */
public class PairSum {

  public static void main(String[] args) {
    printPair(new int[]{1, 4, 45, 6, 10, -8}, 16);
//    printpairs(new int[]{1, 4, 45, 6, 10, -8}, 14);
  }

  private static void printpairs(int arr[], int sum) {
    HashSet<Integer> s = new HashSet<>();
    for (int i : arr) {
      int temp = sum - i;
      if (temp >= 0 && s.contains(temp)) {
        System.out.println("Pair with given sum " +
            sum + " is (" + i + ", " + temp + ")");
      }
      s.add(i);
    }
  }

  private static void printPair(int[] arr, int sum) {
    Arrays.sort(arr);
    Utils.printArray(arr);
    int l = 0;
    int r = arr.length - 1;
    while (l < r) {
      int localSum = arr[l] + arr[r];
      if (localSum == sum) {
        System.out.println(String.format("%d + %d = %d", arr[l], arr[r], sum));
        return;
      }
      if (localSum > sum) {
        r--;
      } else {
        l++;
      }
    }
  }
}
