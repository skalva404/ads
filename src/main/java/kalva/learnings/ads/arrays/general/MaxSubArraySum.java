package kalva.learnings.ads.arrays.general;

public class MaxSubArraySum {

  static int maxSumArraySum(int[] array) {
    int localSum = 0;
    int globalSum = 0;
    for (int i1 : array) {
      localSum = Math.max(i1, localSum + i1);
      globalSum = Math.max(globalSum, localSum);
      System.out.println(localSum + "\t" + globalSum);
    }
    return globalSum;
  }

  public static void main(String[] args) {
    System.out.println(maxSumArraySum(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
  }
}
