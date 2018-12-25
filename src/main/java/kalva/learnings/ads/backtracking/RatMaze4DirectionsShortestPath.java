package kalva.learnings.ads.backtracking;

public class RatMaze4DirectionsShortestPath {

  static int N = 5;
  static int maze[][] = {
      {1, 0, 1, 1, 1},
      {1, 0, 1, 0, 1},
      {1, 1, 1, 0, 1},
      {1, 0, 0, 0, 1},
      {1, 1, 1, 1, 1}};
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
    return y >= 0 && x >= 0 && y < N && x < N;
  }

  static boolean isValid(int x, int y) {
    return 1 == maze[x][y] && 0 == sol[x][y];
  }

  private static int solveMaze(int x, int y, int runningDistance, int shortestDistance) {
    if (x == N - 1 && y == N - 1) {
      return Math.min(runningDistance, shortestDistance);
    }
    sol[x][y] = 1;
    if (isSafe(x, y + 1) && isValid(x, y + 1)) {
      shortestDistance = solveMaze(x, y + 1, runningDistance + 1, shortestDistance);
    }
    if (isSafe(x + 1, y) && isValid(x + 1, y)) {
      shortestDistance = solveMaze(x + 1, y, runningDistance + 1, shortestDistance);
    }
    if (isSafe(x, y - 1) && isValid(x, y - 1)) {
      shortestDistance = solveMaze(x, y - 1, runningDistance + 1, shortestDistance);
    }
    if (isSafe(x - 1, y) && isValid(x - 1, y)) {
      shortestDistance = solveMaze(x - 1, y, runningDistance + 1, shortestDistance);
    }
    sol[x][y] = 0;
    return shortestDistance;
  }

  public static void main(String[] args) {
    System.out.println(solveMaze(0, 0, 0, Integer.MAX_VALUE));
    printSolution(sol);
  }
}
