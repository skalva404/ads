package kalva.learnings.ads.backtracking;

public class RatMaze {

  static int r = 4;
  static int c = 4;
  //  static int maze[][] = {
//      {1, 1, 1, 1},
//      {0, 0, 0, 1},
//      {0, 0, 0, 1},
//      {0, 0, 0, 1}};
  static int maze[][] = {
      {1, 1, 0, 0},
      {1, 1, 1, 1},
      {0, 1, 0, 0},
      {1, 1, 1, 1}};
  static int sol[][] = {
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0}};

  /* A utility function to print solution matrix
       sol[N][N] */
  static void printSolution(int sol[][]) {
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++)
        System.out.print(" " + sol[i][j] + " ");
      System.out.println();
    }
  }

  static boolean isSafe(int row, int col) {
    return row < r && col < c && 1 == maze[row][col];
  }

  private static boolean solveMaze(int x, int y) {
    if (!isSafe(x, y)) {
      return false;
    }

    sol[x][y] = 1;
    if (x == c - 1 && y == r - 1) {
      return true;
    }
    if (solveMaze(x + 1, y)) {
      return true;
    }
    if (solveMaze(x, y + 1)) {
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
