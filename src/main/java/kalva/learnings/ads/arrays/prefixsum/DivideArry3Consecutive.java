package kalva.learnings.ads.arrays.prefixsum;

import java.util.ArrayList;
import java.util.List;

import static kalva.learnings.ads.arrays.prefixsum.PrefixSum.prefixSum;
import static kalva.learnings.ads.arrays.prefixsum.PrefixSum.suffixSum;

//TODO not completd
public class DivideArry3Consecutive {

  public static void main(String[] args) {
    System.out.println(divideArry3Consecutive(new Integer[]{1, 2, 3, 0, 3}));
  }

  static int divideArry3Consecutive(Integer[] data) {
    int i = 0;
    Integer[] pSum = prefixSum(data);
    Integer[] sSum = suffixSum(data);
    int sum = pSum[data.length - 1];

    List<Integer> indexes = new ArrayList<>();
    for (int j = 0; j < pSum.length; j++) {
      if (sSum[j] == sum / 3) {
        indexes.add(j);
      }
    }

    for (int j = 0; j < pSum.length; j++) {
      if (pSum[j] == sum / 3) {
        int res = indexes.indexOf(j + 1);
        if (-1 != res) {
          i += indexes.size() - res;
        }
      }
    }
    return i;
  }
}
