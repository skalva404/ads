package kalva.learnings.ads.againdp;

import java.util.ArrayList;
import java.util.List;

//https://tutorialspoint.dev/algorithm/dynamic-programming-algorithms/convert-strictly-increasing-array-minimum-changes
//Input { 1, 2, 5, 3, 4 }
//Output {1, 2, 5}
public class LongIncStrictSeq {

    static List<Integer> longIncStrictSeq(int[] data) {

        List<Integer> tempList = new ArrayList<>();
        List<Integer> incList = new ArrayList<>();

        int maxSize = Integer.MIN_VALUE;
        for (int i = 0; i < data.length; i++) {
            tempList.add(data[i]);
            for (int j = i; j < data.length - 1; j++) {
                if (data[j] < data[j + 1]) {
                    tempList.add(data[j + 1]);
                } else {
                    break;
                }
            }
            if (maxSize <= tempList.size()) {
                maxSize = tempList.size();
                incList = new ArrayList<>(tempList);
            }

            tempList.clear();
        }
        return incList;
    }

    static int minRemove(int arr[], int n) {

        int LIS[] = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            LIS[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && (i - j) <= (arr[i] - arr[j])) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
            len = Math.max(len, LIS[i]);
        }
        return n - len;
    }

    public static void main(String[] args) {

        System.out.println(longIncStrictSeq(new int[]{1, 2, 5, 3, 4, 5}));

        int arr[] = {1, 2, 6, 3, 4};
        int n = arr.length;
        System.out.println(minRemove(arr, n));
    }
}
