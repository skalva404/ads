package kalva.learnings.ads.arrays;

import java.util.BitSet;

public class MissingNumberInArray {

  public static void main(String[] args) {
    // one missing number
    printMissingNumber(new int[]{1, 2, 3, 4, 6}, 6);
    // two missing number
    printMissingNumber(new int[]{1, 2, 3, 4, 6, 7, 9, 8, 10}, 10);
    // three missing number
    printMissingNumber(new int[]{1, 2, 3, 4, 6, 9, 8}, 10);
    // four missing number
    printMissingNumber(new int[]{1, 2, 3, 4, 9, 8}, 10);
  }

  private static void printMissingNumber(int[] numbers, int count) {
    int missing = count - numbers.length;
    BitSet bitSet = new BitSet(count);
    for (int number : numbers) {
      bitSet.set(number - 1);
    }
    int lastMissingIndex = 0;
    for (int i = 0; i < missing; i++) {
      lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
      System.out.print(++lastMissingIndex + "\t");
    }
    System.out.println();
  }
}
