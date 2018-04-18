package kalva.learnings.ads;

import java.text.DecimalFormat;

import kalva.learnings.ads.tree.Node;

public class Utils {

  public static int height(Node root) {
    if (null == root) {
      return 0;
    }
    return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
  }

  public static void printInt(Integer data) {
    DecimalFormat twodigits = new DecimalFormat("00");
    System.out.print(twodigits.format(data) + "  ");
  }

  public static void main(String[] args) {
    System.out.println(height(Node.createSampleTree()));
  }
}
