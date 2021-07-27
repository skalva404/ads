package kalva.learnings.ads.backtracking;

public class RateMazeCountPaths {

  static int N = 5;
  static int maze[][] = {
      {1, 0, 1, 1, 1},
      {1, 0, 1, 0, 1},
      {1, 1, 1, 0, 1},
      {1, 0, 0, 0, 1},
      {1, 1, 1, 1, 1}};

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

  static boolean isVEnd(int x, int y) {
    return (x == N - 1) && (y == N - 1);
  }

//  private static int solveMaze(int x, int y) {
//
//  }
}
