package kalva.learnings.ads.arrays.general;

public class AreConsecutive {

  private boolean areConsecutive(int arr[]) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i1 : arr) {
      if (min > i1) {
        min = i1;
      }
      if (max < i1) {
        max = i1;
      }
    }
    if (max - min + 1 != arr.length) {
      return false;
    }
    for (int i = 0; i < arr.length; i++) {
      int j = Math.abs(arr[i]) - min;
      if (arr[j] > 0) {
        arr[j] = -arr[j];
      } else {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    AreConsecutive consecutive = new AreConsecutive();
    int arr[] = {5, 4, 2, 3, 1, 6};
    System.out.println(consecutive.areConsecutive(arr));
  }
}
