package kalva.learnings.ads.backtracking;

import java.util.Arrays;

//https://www.youtube.com/watch?v=RnlHPR0lyOE
//https://algorithms.tutorialhorizon.com/generate-all-strings-of-n-bits/
public class NbitsStrings {
  private int[] arrA;

  private NbitsStrings(int n) {
    arrA = new int[n];
    for (int i = 0; i < n; i++) {
      arrA[i] = -1;
    }
  }

  private void nBits1(int n) {

  }
  private void nBits(int n) {
    if (n <= 0) {
      System.out.println(Arrays.toString(arrA));
    } else {
      arrA[n - 1] = 0;
      nBits(n - 1);
      arrA[n - 1] = 1;
      nBits(n - 1);
    }
  }

  public static void main(String[] args) throws java.lang.Exception {
    int n = 2;
    NbitsStrings i = new NbitsStrings(n);
    i.nBits(n);
  }
}
