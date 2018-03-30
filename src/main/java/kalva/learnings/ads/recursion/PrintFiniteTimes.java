package kalva.learnings.ads.recursion;

public class PrintFiniteTimes {

  public static void main(String[] args) {
    loop(10);
    System.out.println();
    reverseLoop(10);
  }

  private static boolean loop(int value) {
    if (1 == value) {
      System.out.print(value + "\t");
      return true;
    }
    if (loop(value - 1)) {
      System.out.print(value + "\t");
      return true;
    }
    return false;
  }

  private static boolean reverseLoop(int value) {
    System.out.print(value + "\t");
    if (1 == value) {
      return false;
    }
    return reverseLoop(value - 1);
  }
}
