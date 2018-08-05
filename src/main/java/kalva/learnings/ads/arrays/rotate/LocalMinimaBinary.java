package kalva.learnings.ads.arrays.rotate;

public class LocalMinimaBinary {
  public static void main(String[] args) {

    int[] arrA = {11, 4, 2, 5, 11, 13, 1, 8, 10};
    boolean isInc = arrA[0] - arrA[1] < 0;
    for (int i = 2; i < arrA.length; i++) {
      boolean isDec = arrA[i - 1] - arrA[i] > 0;
      if (isInc && isDec) {
        System.out.println("Min Element found :: " + arrA[i - 1]);
        break;
      }
      if (!isInc && !isDec) {
        System.out.println("Min Element found :: " + arrA[i - 1]);
        break;
      }
    }
  }
}
