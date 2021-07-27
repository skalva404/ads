package kalva.learnings.ads.dp;

import kalva.learnings.ads.Utils;

import static kalva.learnings.ads.Utils.getOrDefault;
import static kalva.learnings.ads.Utils.printArray;

public class LCSPath {

    public static void main(String[] args) {

        String X = "ABCBDAB", Y = "BDCABA";
        int m = X.length(), n = Y.length();

        int[][] T = new int[m][n];
        LCSLength(X, Y, m, n, T);
        printArray(T);
        System.out.println(LCS(X, Y, m - 1, n - 1, T));
    }

    private static String LCS(String X, String Y, int m, int n, int[][] T) {
        if (0 > m || 0 > n) {
            return "";
        }
        if (Utils.getOrDefault(m - 1, n, T) == Utils.getOrDefault(m, n - 1, T)) {
            return LCS(X, Y, m - 1, n - 1, T) + X.charAt(m);
        } else if (Utils.getOrDefault(m - 1, n, T) > Utils.getOrDefault(m, n - 1, T)) {
            return LCS(X, Y, m - 1, n, T);
        } else {
            return LCS(X, Y, m, n - 1, T);
        }
    }

    public static void LCSLength(String X, String Y, int m, int n, int[][] T) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (X.charAt(i) == Y.charAt(j)) {
                    T[i][j] = 1 + getOrDefault(i - 1, j - 1, T);
                } else {
                    T[i][j] = Integer.max(getOrDefault(i - 1, j, T), getOrDefault(i, j - 1, T));
                }
            }
        }
    }
}
