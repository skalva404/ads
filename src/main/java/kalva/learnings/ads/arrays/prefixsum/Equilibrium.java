package kalva.learnings.ads.arrays.prefixsum;

import java.util.Arrays;

public class Equilibrium {

  public static void main(String[] args) {

    int arr[] = {-7, 1, 5, 2, -4, 3, 0};
    int lSum = 0;
    int sum = Arrays.stream(arr).sum();
    for (int i = 0; i < arr.length; i++) {
      sum -= arr[i];
      if (sum == lSum) {
        System.out.println("Found = " + i);
      }
      lSum += arr[i];
    }
  }
}
