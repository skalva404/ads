package kalva.learnings.ads.backtracking;

/**
 * https://algorithms.tutorialhorizon.com/dynamic-programming-subset-sum-problem/
 */
public class SubSetSum {

  private static void findSubsetSum(int a[], int sum, int index, int currSum, int sol[]) {
    if (index >= a.length) {
      if (currSum != sum) {
        return;
      }
      for (int i = 0; i < sol.length; i++) {
        if (sol[i] == 1) {
          System.out.print("  " + a[i]);
        }
      }
      System.out.println();
    } else {
      sol[index] = 1;
      currSum += a[index];
      findSubsetSum(a, sum, index + 1, currSum, sol);
      sol[index] = 0;
      currSum -= a[index];
      findSubsetSum(a, sum, index + 1, currSum, sol);
    }
  }

  public static void main(String[] args) {
    int[] A = {3, 2, 7, 1, 4};
    findSubsetSum(A, 6, 0, 0, new int[A.length]);
  }
}
