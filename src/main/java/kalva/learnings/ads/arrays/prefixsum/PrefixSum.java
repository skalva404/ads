package kalva.learnings.ads.arrays.prefixsum;

import java.util.Arrays;

public class PrefixSum {
  public static void main(String[] args) {
    Integer arr[] = {1, 3, 4, 5, 2, 7, 8, 11};
    System.out.println(Arrays.asList(arr));
    System.out.println(Arrays.asList(prefixSum(arr)));
    System.out.println(Arrays.asList(suffixSum(arr)));
  }

  public static Integer[] prefixSum(Integer[] arr) {
    Integer res[] = new Integer[arr.length];
    res[0] = arr[0];
    for (int i = 1; i < res.length; i++) {
      res[i] = res[i - 1] + arr[i];
    }
    return res;
  }

  public static Integer[] suffixSum(Integer[] arr) {
    Integer res[] = new Integer[arr.length];
    res[arr.length - 1] = arr[arr.length - 1];
    for (int i = arr.length - 2; i >= 0; i--) {
      res[i] = res[i + 1] + arr[i];
    }
    return res;
  }
}
