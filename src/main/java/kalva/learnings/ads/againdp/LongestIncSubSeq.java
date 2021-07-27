package kalva.learnings.ads.againdp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.stream.Collectors;

public class LongestIncSubSeq {

    private static int longestIncSubseqWithNSquare(int[] data) {
        if (1 >= data.length) {
            return data.length;
        }

        int max = -1;
        int[] dpTable = new int[data.length];
        Arrays.fill(dpTable, 1);
        for (int i = 1; i < data.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (data[j] < data[i]) {
                    dpTable[i] = Math.max(dpTable[i], dpTable[j] + 1);
                }
            }
            max = Math.max(max, dpTable[i]);
        }
        return max;
    }

    private static int longestIncSubseq(int[] data) {

        Integer[] sorted = Arrays.stream(data)
                .boxed()
                .sorted()
                .collect(Collectors.toList())
                .toArray(new Integer[data.length]);

        int L[][] = new int[data.length + 1][data.length + 1];
        for (int i = 1; i <= data.length; i++) {
            for (int j = 1; j <= data.length; j++) {
                if (data[i - 1] == sorted[j - 1]) {
                    L[i][j] = 1 + L[i - 1][j - 1];
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }
        return L[L.length - 1][L.length - 1];
    }

    private static void printLongestIncSubseqWithNSquare(int[] data) {

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> longestList = new ArrayList<Integer>();
        int currentMax;
        int highestCount = 0;

        for (int i = 0; i < data.length; i++) {
            currentMax = Integer.MIN_VALUE;
            for (int j = i; j < data.length; j++) {
                if (data[j] > currentMax) {
                    list.add(data[j]);
                    currentMax = data[j];
                }
            }

            if (highestCount < list.size()) {
                highestCount = list.size();
                longestList = new ArrayList<>(list);
            }
            list.clear();
        }
        System.out.println();

        //Print list
        Iterator<Integer> itr = longestList.iterator();
        System.out.println("The Longest subsequence");
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
        System.out.println("Length of LIS: " + highestCount);
    }

    private static void printLongestIncSubseqWithDP(int[] arr) {

        Vector[] L = new Vector[arr.length];
        for (int i = 0; i < L.length; i++) {
            L[i] = new Vector<Integer>();
        }
        L[0].add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((arr[i] > arr[j]) && (L[i].size() < L[j].size() + 1)) {
                    L[i] = L[j];
                }
            }
            L[i].add(arr[i]);
        }

        Vector<Integer> max = L[0];
        for (Vector<Integer> x : L) {
            if (x.size() > max.size()) {
                max = x;
            }
        }
        System.out.println("The Longest subsequence using DP");
        for (int x : max)
            System.out.print(x + " ");
    }

    public static void main(String[] args) {
//        int[] data = new int[]{3, 1, 4, 5, 1};
        int[] data = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
//        int[] data = new int[]{12, 34, 1, 5, 40, 80};
//        System.out.println(longestIncSubseq(data));
//        System.out.println(longestIncSubseqWithNSquare(data));
        printLongestIncSubseqWithNSquare(data);
//        printLongestIncSubseqWithDP(data);
    }
}
