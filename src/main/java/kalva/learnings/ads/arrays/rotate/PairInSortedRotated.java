package kalva.learnings.ads.arrays.rotate;

/**
 * https://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/
 */
public class PairInSortedRotated {

  public static void main(String[] args) {
    pairInSortedRotated(new int[]{11, 15, 1, 6, 8, 9, 10}, 16);
  }

  private static void pairInSortedRotated(int arr[], int x) {
    // Find the pivot element
    int i;
    int n = arr.length;
    for (i = 0; i < n - 1; i++)
      if (arr[i] > arr[i + 1])
        break;
    int l = (i + 1) % n;
    int r = i;
    System.out.println(String.format("pivot point = %d", i));
    while (l != r) {
      int localSum = arr[l] + arr[r];
      if (localSum == x) {
        System.out.println(String.format("%d + %d = %d", arr[l], arr[r], x));
        return;
      }
      if (localSum < x) {
        l = (l + 1) % n;
      } else {
        r = (n + r - 1) % n;
      }
    }
  }
}
