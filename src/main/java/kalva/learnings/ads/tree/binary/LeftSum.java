package kalva.learnings.ads.tree.binary;

import kalva.learnings.ads.tree.TreeNode;

public class LeftSum {

  private static int leftSum(TreeNode node) {
    if (null == node || null == node.getLeft()) {
      return 0;
    }
    return node.getLeft().getData() + leftSum(node.getLeft()) + leftSum(node.getRight());
  }

  public static void main(String[] args) {
    System.out.println(leftSum(TreeNode.createSampleTree()));
  }
}
