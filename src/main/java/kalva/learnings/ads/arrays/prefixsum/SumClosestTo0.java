package kalva.learnings.ads.arrays.prefixsum;


import static kalva.learnings.ads.arrays.prefixsum.PrefixSum.prefixSum;

public class SumClosestTo0 {
  public static void main(String[] args) {

    Integer arr[] = {2, 3, -4, -1, 6};
    Integer[] prefixSum = prefixSum(arr);
    System.out.println(prefixSum);
  }
}
