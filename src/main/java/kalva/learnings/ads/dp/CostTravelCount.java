package kalva.learnings.ads.dp;

public class CostTravelCount {

    private static void resolveTotalCount(int mat[][], int m, int n, int i, int j, int path[],
                                          int idx, int maxCost, Result result) {
        path[idx] = mat[i][j];

        //When we reach to bottom just move right
        if (i == m - 1) {
            for (int k = j + 1; k < n; k++) {
                path[idx + k - j] = mat[i][k];
            }
            int sum = 0;
            for (int l = 0; l < idx + n - j; l++) {
                sum = sum + path[l];
            }
            if (sum == maxCost)
                result.res++;
            return;
        }

        //When we reach to right just move down
        if (j == n - 1) {
            for (int k = i + 1; k < m; k++) {
                path[idx + k - i] = mat[k][j];
            }
            int sum = 0;
            for (int l = 0; l < idx + m - i; l++) {
                sum = sum + path[l];
            }
            if (sum == maxCost)
                result.res++;
            return;
        }

        resolveTotalCount(mat, m, n, i + 1, j, path, idx + 1, maxCost, result);
        resolveTotalCount(mat, m, n, i, j + 1, path, idx + 1, maxCost, result);
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 4;
        int mat[][] = {
                {4, 7, 1, 6},
                {5, 7, 3, 9},
                {3, 2, 1, 2},
                {7, 1, 6, 3}
        };

        int maxLengthOfPath = m + n - 1;
        int maxCost = 25;
        Result result = new Result();
        resolveTotalCount(mat, m, n, 0, 0, new int[maxLengthOfPath], 0, maxCost, result);
        System.out.println(result.res);
    }

}

class Result {
    int res;

    public Result() {
    }
}
