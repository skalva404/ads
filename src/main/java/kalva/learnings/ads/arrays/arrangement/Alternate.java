package kalva.learnings.ads.arrays.arrangement;

import java.util.Arrays;

public class Alternate {
  private static int[] A = {1, 3, 5, 7, 2, 4, 6, 8};

  private void rearrange(int start, int end) {
    if (start >= end)
      return;
    int mid = start + (end - start) / 2;
    int x = 1 + (start + mid) / 2;
    int y = mid + 1;
    for (int i = x, j = y; i <= mid; i++, j++) {
      swap(i, j);
    }
    rearrange(start, mid);
    rearrange(mid + 1, end);
  }

  private void swap(int m, int n) {
    int temp = A[m];
    A[m] = A[n];
    A[n] = temp;
  }

  public static void main(String[] args) {
    Alternate rng = new Alternate();
    rng.rearrange(0, A.length - 1);
    System.out.println(Arrays.toString(A));
  }
}
