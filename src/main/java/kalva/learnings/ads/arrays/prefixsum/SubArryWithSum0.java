package kalva.learnings.ads.arrays.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class SubArryWithSum0 {
  public static void main(String[] args) {
    int sum = 0;
    Integer arr[] = {1, 4, -2, -2, 5, -4, 3};
    Map<Integer, Integer> counts = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      Integer count = counts.computeIfAbsent(sum, s -> 0);
      if (count > 0) {
        System.out.println(i);
        return;
      }
      counts.put(sum, ++count);
    }
  }
}
