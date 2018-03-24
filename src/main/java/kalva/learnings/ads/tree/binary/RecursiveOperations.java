package kalva.learnings.ads.tree.binary;

import static kalva.learnings.ads.tree.TreeNode.createSampleTree;

import kalva.learnings.ads.tree.TreeNode;

public class RecursiveOperations {

  private TreeNode node;

  public RecursiveOperations(TreeNode node) {
    this.node = node;
  }

  public void inOrder() {
    inOrder(node);
  }

  public void printPreOrder() {
    printPreOrder(node);
  }

  private void inOrder(TreeNode root) {
    if (null == root) {
      return;
    }
    inOrder(root.getLeft());
    System.out.print(root.getData() + "\t");
    inOrder(root.getRight());
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
    RecursiveOperations operations = new RecursiveOperations(createSampleTree());
    operations.printPreOrder();
  }
}
