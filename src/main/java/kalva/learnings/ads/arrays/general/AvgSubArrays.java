package kalva.learnings.ads.arrays.general;

public class AvgSubArrays {
  public static void main(String[] args) {
    int arr[] = {1, 5, 7, 2, 0};
    findSubarrays(arr);
  }

  static void findSubarrays(int arr[]) {
    int sum = 0;
    int n = arr.length;
    for (int anArr : arr) sum += anArr;

    int lsum = 0;
    int rsum = 0;
    for (int i = 0; i < arr.length; i++) {
      lsum += arr[i];
      rsum = sum - lsum;
      System.out.println((lsum * (n - i - 1)) + "  " + (rsum * (i + 1)));
    }
  }
}
