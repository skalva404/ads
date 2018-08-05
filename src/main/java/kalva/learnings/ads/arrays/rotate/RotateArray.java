package kalva.learnings.ads.arrays.rotate;

public class RotateArray {

  public static void main(String[] args) {
    printArray(new int[]{1, 2, 3, 4, 5, 6, 7});
    reverseArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 2);
//    reversalArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 2);
  }

  private static void reverseArray(int[] arr, int d) {
    for (int i = 1; i <= d; i++) {
      int temp = arr[0];
      System.arraycopy(arr, 1, arr, 0, arr.length - 1);
      arr[arr.length - 1] = temp;
    }
    printArray(arr);
  }

  private static void reversalArray(int[] arr, int d) {
    reverseArray(arr, 0, d - 1);
    reverseArray(arr, d, arr.length - 1);
    reverseArray(arr, 0, arr.length - 1);
    printArray(arr);
  }

  //https://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-algorithm/
  private static void reverseArray(int[] arr, int start, int end) {
    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }

  private static void printArray(int[] arr) {
    for (int i1 : arr) {
      System.out.print(i1 + "\t");
    }
    System.out.println();
  }
}
