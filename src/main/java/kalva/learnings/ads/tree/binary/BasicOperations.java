package kalva.learnings.ads.tree.binary;

import kalva.learnings.ads.tree.TreeNode;

public class BasicOperations {

  private TreeNode node;

  public BasicOperations(TreeNode node) {
    this.node = node;
  }

  public void printPreOrder() {
    printPreOrder(node);
  }

  private void printPreOrder(TreeNode root) {
    if (null == root) {
      return;
    }
    System.out.print(root.getData() + "\t");
    printPreOrder(root.getLeft());
    printPreOrder(root.getRight());
  }

  public static void main(String[] args) {
    BasicOperations operations = new BasicOperations(TreeNode.createSampleTree());
    operations.printPreOrder();
  }
}
