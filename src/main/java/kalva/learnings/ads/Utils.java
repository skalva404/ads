package kalva.learnings.ads;

import java.text.DecimalFormat;

import kalva.learnings.ads.tree.TreeNode;

public class Utils {

  public static int height(TreeNode root) {
    if (null == root) {
      return 0;
    }
    return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
  }

  public static void print(Integer data) {
    DecimalFormat twodigits = new DecimalFormat("00");
    System.out.print(twodigits.format(data) + "  ");
  }

  public static void main(String[] args) {
    System.out.println(height(TreeNode.createSampleTree()));
  }
}
