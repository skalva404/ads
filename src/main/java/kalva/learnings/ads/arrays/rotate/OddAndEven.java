package kalva.learnings.ads.arrays.rotate;

public class OddAndEven {
  public static void main(String[] args) {
    int[] arrA = {1, 2, 3, 4, 6, 8, 7, 12};
    for (int i : arrA) {
      System.out.print(i + "\t");
    }
    swapOrders(arrA);
    System.out.println();
    for (int i : arrA) {
      System.out.print(i + "\t");
    }
  }

  private static void swapOrders(int[] array) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      if (0 == array[left] % 2) {
        left++;
      } else if (0 != array[right] % 2) {
        right--;
      } else {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
      }
    }
  }
}
