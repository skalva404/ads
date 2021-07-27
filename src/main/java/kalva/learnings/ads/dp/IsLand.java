package kalva.learnings.ads.dp;

class IsLand {

    static final int R = 4, C = 4;

    boolean isValidMove(int M[][], int row, int col, boolean visited[][]) {
        return (row >= 0) && (row < R) && (col >= 0) && (col < C) && (M[row][col] == 1 && !visited[row][col]);
    }

    void DFS(int M[][], int row, int col, boolean visited[][]) {

        int rowNeigohours[] = new int[]{-1, 0, 1, 0};

        int colNeigohours[] = new int[]{0, -1, 0, 1,};

        visited[row][col] = true;

        for (int k = 0; k < 4; k++) {
            if (isValidMove(M, row + rowNeigohours[k], col + colNeigohours[k], visited)) {
                DFS(M, row + rowNeigohours[k], col + colNeigohours[k], visited);
            }
        }
    }

    int getCountOfIslands(int M[][]) {

        boolean visited[][] = new boolean[R][C];
        int count = 0;

        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                if (M[i][j] == 1 && !visited[i][j]) {
                    DFS(M, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int matrix[][] = new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {0, 1, 0, 0}, {0, 1, 1, 1}};
        IsLand i = new IsLand();
        System.out.println("No of islands " + i.getCountOfIslands(matrix));
    }
}