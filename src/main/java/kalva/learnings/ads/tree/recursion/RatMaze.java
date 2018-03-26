package kalva.learnings.ads.tree.recursion;

public class RatMaze {

  static int r = 4;
  static int c = 4;
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

  /* A utility function to check if x,y is valid
      index for N*N maze */
  static boolean isSafe(int maze[][], int x, int y) {
    // if (x,y outside maze) return false
    return (x >= 0 && x < r && y >= 0 &&
        y < c && maze[x][y] == 1);
  }

  static boolean solveMaze(int x, int y) {
    if (x == c - 1 && y == r - 1) {
      sol[x][y] = 1;
      return true;
    }
    if (!isSafe(maze, x, y)) {
      return false;
    }
    sol[x][y] = 1;
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
