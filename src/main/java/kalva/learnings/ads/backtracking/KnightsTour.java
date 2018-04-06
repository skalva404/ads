package kalva.learnings.ads.backtracking;

import java.text.DecimalFormat;

/**
 * https://algorithms.tutorialhorizon.com/backtracking-knights-tour-problem
 */
public class KnightsTour {

  static int N = 8;
  static int path = 0;
  static int[][] solution = new int[N][N];

  static {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        solution[i][j] = 0;
      }
    }
  }

  static void print() {
    DecimalFormat twodigits = new DecimalFormat("00");
    for (int[] aSolution : solution) {
      for (int j = 0; j < solution.length; j++) {
        System.out.print("   " + twodigits.format(aSolution[j]));
      }
      System.out.println();
    }
  }

  static boolean move(int row, int col, int index) {

    if (!canMove(row, col)) {
      return false;
    }

    solution[row][col] = path++;
    if (index == N * N - 1) {
      return true;
    }

    if (move(row - 2, col - 1, index + 1)) {
      return true;
    }
    if (move(row - 2, col + 1, index + 1)) {
      return true;
    }

    if (move(row - 1, col - 2, index + 1)) {
      return true;
    }
    if (move(row - 1, col + 2, index + 1)) {
      return true;
    }

    if (move(row + 1, col - 2, index + 1)) {
      return true;
    }
    if (move(row + 1, col + 2, index + 1)) {
      return true;
    }

    if (move(row + 2, col - 1, index + 1)) {
      return true;
    }
    if (move(row + 2, col + 1, index + 1)) {
      return true;
    }

    solution[row][col] = 0;
    path--;

    return false;
  }

  static boolean canMove(int row, int col) {
    return row >= 0 && row < N && col >= 0 && col < N && 0 == solution[row][col];
  }

  public static void main(String[] args) {
    move(0, 0, 0);
    print();
  }
}
