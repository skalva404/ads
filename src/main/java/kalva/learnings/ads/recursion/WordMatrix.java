package kalva.learnings.ads.recursion;

/**
 * https://algorithms.tutorialhorizon.com/backtracking-search-a-word-in-a-matrix/
 */
public class WordMatrix {

  static int N = 5;
  static int path = 1;
  static int[][] solution = new int[N][N];

  static char[][] matrix = {
      {'t', 'z', 'x', 'c', 'd'},
      {'a', 'h', 'n', 'z', 'x'},
      {'h', 'w', 'o', 'i', 'o'},
      {'o', 'r', 'n', 'r', 'n'},
      {'a', 'b', 'r', 'i', 'n'}};

  static {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        solution[i][j] = 0;
      }
    }
  }

  public static void main(String[] args) {
    if (solveMatrix(1, 1, "horizon", 0)) {
      print();
    } else {
      System.out.println("No solution found ....!");
    }
  }

  static void print() {
    for (int[] aSolution : solution) {
      for (int j = 0; j < solution.length; j++) {
        System.out.print(" " + aSolution[j]);
      }
      System.out.println();
    }
  }

  static boolean isSafe(int row, int col, String word, int index) {
    return col < N && row < N && col >= 0 && row >= 0 &&
        0 == solution[row][col] &&
        index >= 0 && matrix[row][col] == word.charAt(index);
  }

  static boolean solveMatrix(int row, int col, String word, int index) {
    if (!isSafe(row, col, word, index)) {
      return false;
    }

    solution[row][col] = path++;
    if (word.length() - 1 == index) {
      return true;
    }
    if (solveMatrix(row - 1, col, word, index + 1)) {
      return true;
    }
    if (solveMatrix(row - 1, col + 1, word, index + 1)) {
      return true;
    }
    if (solveMatrix(row, col + 1, word, index + 1)) {
      return true;
    }
    if (solveMatrix(row + 1, col + 1, word, index + 1)) {
      return true;
    }
    if (solveMatrix(row + 1, col, word, index + 1)) {
      return true;
    }
    if (solveMatrix(row + 1, col - 1, word, index + 1)) {
      return true;
    }
    if (solveMatrix(row, col - 1, word, index + 1)) {
      return true;
    }
    if (solveMatrix(row - 1, col - 1, word, index + 1)) {
      return true;
    }

    solution[row][col] = 0;
    path--;
    return false;
  }
}
