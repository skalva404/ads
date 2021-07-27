package kalva.learnings.ads.backtracking;

public class RatMaze4Directions {

    static int N = 5;
    static int maze[][] = {
            {1, 0, 1, 1, 1,},
            {1, 0, 1, 0, 1},
            {1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1},
            {0, 0, 1, 1, 1}};
    static int sol[][] = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}};

    static void printSolution(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + sol[i][j] + " ");
            System.out.println();
        }
    }

    static boolean isSafe(int x, int y) {
        return y >= 0 && x >= 0 && y < N && x < N && 1 == maze[x][y] && 0 == sol[x][y];
    }

    private static boolean solveMaze(int x, int y) {
        if (x == N - 1 && y == N - 1) {
            sol[x][y] = 1;
            return true;
        }

        if (!isSafe(x, y)) {
            return false;
        }

        sol[x][y] = 1;
        if (solveMaze(x + 1, y)) {
            return true;
        }
        if (solveMaze(x - 1, y)) {
            return true;
        }
        if (solveMaze(x, y + 1)) {
            return true;
        }
        if (solveMaze(x, y - 1)) {
            return true;
        }
        sol[x][y] = 0;
        return false;
    }

    public static void main(String[] args) {
        if (solveMaze(0, 0)) {
            printSolution(sol);
        }
    }
}
