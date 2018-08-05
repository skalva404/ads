package kalva.learnings.ads.arrays.prefixsum;

public class MaxOccured {

  public static void main(String[] args) {
    int L[] = {1, 5};
    int R[] = {5, 11};
//    int L[] = {1, 4, 3, 1};
//    int R[] = {15, 8, 5, 4};
    System.out.println(maximumOccuredElement(L, R, L.length));
  }

  static int maximumOccuredElement(int L[], int R[], int n) {
    int arr[] = new int[17];
    for (int i = 0; i < n; i++) {
      arr[L[i]]++;
      arr[R[i] + 1]--;
    }

    int max = Integer.MIN_VALUE;
    int ind = 0;
    for (int i = 1; i < 17; i++) {
      arr[i] += arr[i - 1];
      if (max < arr[i]) {
        max = arr[i];
        ind = i;
      }
    }
    return ind;
  }
}
