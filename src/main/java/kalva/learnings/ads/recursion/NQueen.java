package kalva.learnings.ads.recursion;

public class NQueen {

  // driver program to test above function
  public static void main(String args[]) {
    solveNQ();
  }

  static boolean solveNQ() {
    int board[][] = {
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}
    };

    if (!solveNQUtil(board, 0)) {
      System.out.print("Solution does not exist");
      return false;
    }

    printSolution(board);
    return true;
  }

  private static boolean solveNQUtil(int[][] board, int col) {
    if (col >= board.length) {
      return true;
    }
    for (int row = 0; row < board.length; row++) {
      if (!isSafe(board, row, col)) {
        continue;
      }
      board[row][col] = 1;
      if (solveNQUtil(board, col + 1)) {
        return true;
      }
      board[row][col] = 0;
    }
    return false;
  }

  static boolean isSafe(int board[][], int row, int col) {

    /*Check left side of current row, if any queen is placed*/
    for (int i = 0; i < col; i++) {
      if (isAssigned(board, row, i)) {
        return false;
      }
    }

    /* Check upper diagonal on left side */
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (isAssigned(board, i, j)) {
        return false;
      }
    }

    /* Check lower diagonal on left side */
    for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
      if (isAssigned(board, i, j)) {
        return false;
      }
    }
    return true;
  }

  static void printSolution(int board[][]) {
    for (int[] aBoard : board) {
      for (int j = 0; j < board.length; j++)
        System.out.print(" " + aBoard[j] + " ");
      System.out.println();
    }
  }

  private static boolean isAssigned(int board[][], int row, int col) {
    return 1 == board[row][col];
  }
}
