package kalva.learnings.ads.arrays.rotate;

//https://www.youtube.com/watch?v=bGC2fNALbNU
//https://www.youtube.com/watch?v=0TVDNGLGXYg
//https://www.youtube.com/watch?v=RnlHPR0lyOE
public class PrintArraySubSequences {

  static int sum = 0;

  public static void main(String[] args) {
    printArraySubSequences(new int[]{1, 2, 3}, 3, new int[3]);
    System.out.println(sum);
  }

  private static void printArraySubSequences(int[] a, int index, int[] temp) {
    if (index <= 0) {
      for (int i = 0; i < temp.length; i++) {
        int i1 = temp[i];
        if (0 == i1) {
          continue;
        }
        sum += a[i];
        System.out.print(a[i] + "\t");
      }
      System.out.println();
      return;
    }
    temp[index - 1] = 0;
    printArraySubSequences(a, index - 1, temp);
    temp[index - 1] = 1;
    printArraySubSequences(a, index - 1, temp);
  }
}
