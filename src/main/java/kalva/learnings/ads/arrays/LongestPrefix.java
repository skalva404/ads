package kalva.learnings.ads.arrays;

/**
 * Given two positive integers X and Y, and an array arr[] of positive integers.
 * We need to find the longest prefix index which contains an equal number of X and Y.
 * Print the maximum index of largest prefix if exist otherwise print -1.
 */
public class LongestPrefix {

  public static void main(String[] args) {
    int arr[] = {7, 42, 5, 6, 42, 8, 7, 5, 3, 6, 7};
    System.out.println(findIndex(arr, 7, 42));
  }

  static int findIndex(int arr[], int X, int Y) {
    int nx = 0, ny = 0;
    int result = -1;
    for (int i = 0; i < arr.length; i++) {

      if (arr[i] == X)
        nx++;
      if (arr[i] == Y)
        ny++;

      if (nx == ny && nx != 0)
        result = i;
    }
    return result;
  }
}
