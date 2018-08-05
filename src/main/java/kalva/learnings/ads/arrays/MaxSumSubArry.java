package kalva.learnings.ads.arrays;

public class MaxSumSubArry {
  public static void main(String[] args) {
    System.out.println(maxSum(new int[]{-1, -2, -3, 4, 3, -4, 1, 5, -3}));
  }

  private static int maxSum(int[] data) {
    int maxSum = 0;
    int sum = 0;
    for (int aData : data) {
      sum += aData;
      maxSum = Math.max(sum, maxSum);
      sum = Math.max(0, sum);
    }
    return maxSum;
  }
}
