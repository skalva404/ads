package kalva.learnings.ads.againdp;

import java.util.Arrays;

public class MaxSumIncSubSeq {

    static int maxSumIncSubSeq(int arr[]) {

        int msis[] = new int[arr.length];
        System.arraycopy(arr, 0, msis, 0, msis.length);
        for (int i = 1; i < msis.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    msis[i] = Math.max(msis[i], arr[i] + msis[j]);
                }
            }
        }
        return Arrays.stream(msis).max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(maxSumIncSubSeq(new int[]{2, 1, 3, 100, 4, 5}));
    }
}
