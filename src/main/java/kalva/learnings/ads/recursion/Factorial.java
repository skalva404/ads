package kalva.learnings.ads.recursion;

public class Factorial {
  public static void main(String[] args) {
    System.out.println("Factorial of 5 is: " + factorial(5));
  }

  private static int factorial(int n) {
    if (1 == n) {
      return 1;
    } else {
      return n * factorial(n - 1);
    }
  }
}
