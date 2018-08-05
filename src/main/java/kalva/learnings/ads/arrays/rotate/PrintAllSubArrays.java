package kalva.learnings.ads.arrays.rotate;

public class PrintAllSubArrays {

  static int sum = 0;

  public static void main(String[] args) {
    printSubArrays(new int[]{1, 2, 3});
    System.out.println(sum);
  }

  private static void printSubArrays(int[] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = i; j < a.length; j++) {
        printSubArrays(i, j, a, new int[j - i + 1], 0);
      }
    }
  }

  private static void printSubArrays(int s, int e, int[] a, int[] p, int index) {
    if (s > e) {
      for (int i1 : p) {
        sum += i1;
        System.out.print(i1 + "\t");
      }
      System.out.println();
      return;
    }
    p[index] = a[s];
    printSubArrays(s + 1, e, a, p, index + 1);
  }
}
