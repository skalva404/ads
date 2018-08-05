package kalva.learnings.ads.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimizeSumProduct {

  public static void main(String[] args) {
    Integer A[] = {3, 1, 1};
    Integer B[] = {6, 5, 4};
    System.out.println(minimizeSumProduct(Arrays.asList(A), Arrays.asList(B)));
  }

  static long minimizeSumProduct(List<Integer> A, List<Integer> B) {
    Collections.sort(A);
    Collections.sort(B);
    long p = 0;
    for (int i = 0; i < A.size(); i++) {
      p += A.get(i) * B.get(B.size() - i - 1);
    }
    return p;
  }
}
