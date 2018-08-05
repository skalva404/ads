package kalva.learnings.ads.arrays;

public class LeastAvg {
  public static void main(String[] args) {

    int arr[] = new int[]{3, 7, 90, 20, 10, 50, 40};
    int k = 3;

    int end = 0;
    int sum = 0;
    for (int i = 0; i < k; i++) {
      sum += arr[i];
    }

    for (int i = k; i < arr.length; i++) {
      int movingSum = sum - arr[i - k] + arr[i];
      if (movingSum > sum) {
        sum = movingSum;
        end = i;
      }
    }

    System.out.println(end - k + " to " + (end - 1));
  }
}
