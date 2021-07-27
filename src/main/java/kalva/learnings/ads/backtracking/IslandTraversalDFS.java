package kalva.learnings.ads.backtracking;

public class IslandTraversalDFS {

    private static int totalNumberOfIslands = 0;

    private static void traverseIsland(int[][] islandDetails) {

        int rowLen = islandDetails.length;
        int colLen = islandDetails[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (island(islandDetails[i][j])) {
                    totalNumberOfIslands++;
                    dfs(islandDetails, i, j, rowLen, colLen);
                }
            }
        }
    }

    private static boolean island(int value) {
        return value == 1;
    }

    private static void dfs(int[][] islandDetails, int row, int col, int rowLen, int colLen) {
        if (row < 0 || col < 0 || row >= rowLen || col >= colLen || islandDetails[row][col] == 0) {
            return;
        }
        islandDetails[row][col] = 0;
        dfs(islandDetails, row + 1, col, rowLen, colLen);
        dfs(islandDetails, row, col + 1, rowLen, colLen);
        dfs(islandDetails, row - 1, col, rowLen, colLen);
        dfs(islandDetails, row, col - 1, rowLen, colLen);
    }

    public static void main(String[] args) {
        int[][] islandDetails = new int[][]{{1, 1, 1, 0}, {1, 0, 0, 0}, {0, 1, 0, 0}, {0, 1, 1, 1}};
        traverseIsland(islandDetails);
        System.out.println(totalNumberOfIslands);
    }
}
