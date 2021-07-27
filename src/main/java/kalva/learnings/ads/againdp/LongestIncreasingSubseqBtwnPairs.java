package kalva.learnings.ads.againdp;

import static kalva.learnings.ads.Utils.printArray;

public class LongestIncreasingSubseqBtwnPairs {

    private static int longestCommonIncSubseq(int arr1[], int[] arr2) {

        int l2 = arr2.length;
        int[] dpTable = new int[arr2.length];

        for (int a : arr1) {
            int current = 0;

            for (int j = 0; j < l2; j++) {
                int b = arr2[j];
                int dp = dpTable[j];
                if (a == b) {
                    if (current + 1 > dp) {
                        dpTable[j] = current + 1;
                    }
                }
                if (a > b && dp > current) {
                    current = dp;
                }
            }
            printArray(dpTable);
        }

        int result = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (dpTable[i] > result) {
                result = dpTable[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int arr1[] = {3, 4, 9};
        int arr2[] = {3, 3, 4, 9, 4, 3};
        System.out.println(longestCommonIncSubseq(arr1, arr2));
    }
}
