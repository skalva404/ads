package kalva.learnings.ads.backtracking;

public class IceLand {

  static int maze[][] = {
      {1, 1, 0, 0},
      {1, 0, 0, 0},
      {0, 1, 0, 0},
      {0, 1, 1, 1}};
  static int sol[][] = {
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0}};

  static int r = 4;
  static int c = 4;
  static int counter = 0;

  static void printSolution(int sol[][]) {
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++)
        System.out.print(" " + sol[i][j] + " ");
      System.out.println();
    }
  }

  static boolean isSafe(int row, int col) {
    return row >= 0 && col >= 0 && row < r && col < c && 1 == maze[row][col] && 0 == sol[row][col];
  }

  private static void dfs(int x, int y) {
    if (!isSafe(x, y)) {
      return;
    }
    sol[x][y] = 1;
    counter++;
    dfs(x + 1, y);
    dfs(x - 1, y);
    dfs(x, y + 1);
    dfs(x, y - 1);
  }

  public static void main(String[] args) {
    int total = 0;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        dfs(i, j);
        if (counter > 0) {
          counter = 0;
          total++;
        }
      }
    }
    System.out.println("Total " + total);
    printSolution(sol);
  }
}
