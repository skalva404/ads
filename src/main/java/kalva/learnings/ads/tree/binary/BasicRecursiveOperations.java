package kalva.learnings.ads.tree.binary;

import static kalva.learnings.ads.tree.TreeNode.createSampleTree;

import kalva.learnings.ads.tree.TreeNode;

public class BasicRecursiveOperations {

  private TreeNode node;

  public BasicRecursiveOperations(TreeNode node) {
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
    BasicRecursiveOperations operations = new BasicRecursiveOperations(createSampleTree());
    operations.printPreOrder();
  }
}
