package kalva.learnings.ads.dp;

import java.util.HashMap;
import java.util.Map;

public class CostTravel {

    static int m = 3, n = 3;
    static int[][] mat =
            {
                    {4, 7, 1, 6},
                    {5, 7, 3, 9},
                    {3, 2, 1, 2},
                    {7, 1, 6, 3}
            };
    static int cost = 25;

    public static void main(String[] args) {
        Map<String, Integer> lookup = new HashMap<>();
        System.out.println("Total paths with cost " + cost + " are " + countPaths(mat, cost, 0, 0));
        System.out.println("Total paths with cost " + cost + " are " + countPaths(mat, cost, 0, 0, lookup));
    }

    private static boolean isSafe(int row, int col, int cost) {
        return row >= 0 && col >= 0 && row <= m && col <= n && cost >= 0;
    }

    private static int countPaths(int[][] mat, int cost, int i, int j) {

        if (!isSafe(i, j, cost)) {
            return 0;
        }
        if (i == m && j == n) {
            return 0 == mat[i][j] - cost ? 1 : 0;
        }
        return countPaths(mat, cost - mat[i][j], i, j + 1) +
                countPaths(mat, cost - mat[i][j], i + 1, j);
    }

    private static int countPaths(int[][] mat, int cost, int i, int j, Map<String, Integer> lookup) {

        if (!isSafe(i, j, cost)) {
            return 0;
        }
        if (i == m && j == n) {
            return 0 == mat[i][j] - cost ? 1 : 0;
        }
        String key = i + "|" + j + "|" + cost;
        if (lookup.containsKey(key)) {
            return lookup.get(key);
        }

        lookup.put(key,
                countPaths(mat, cost - mat[i][j], i, j + 1, lookup) +
                        countPaths(mat, cost - mat[i][j], i + 1, j, lookup));
        return lookup.get(key);
    }
}
