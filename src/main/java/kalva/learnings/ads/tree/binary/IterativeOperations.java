package kalva.learnings.ads.tree.binary;

import java.util.Stack;

import static kalva.learnings.ads.tree.TreeNode.createSampleTree;

import kalva.learnings.ads.tree.TreeNode;

public class IterativeOperations {

  private TreeNode node;

  public IterativeOperations(TreeNode node) {
    this.node = node;
  }

  public TreeNode getNode() {
    return node;
  }

  void preorder(TreeNode node) {
    if (node != null) {
      System.out.print(node.getData() + "\t");
      preorder(node.getLeft());
      preorder(node.getRight());
    }
  }

  private void printPreOrder(TreeNode root) {
    if (null == root) {
      return;
    }
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.empty()) {
      TreeNode pop = stack.pop();
      System.out.print(pop.getData() + "\t");
      if (null != pop.getRight()) {
        stack.push(pop.getRight());
      }
      if (null != pop.getLeft()) {
        stack.push(pop.getLeft());
      }
    }
  }

  public static void main(String[] args) {
    IterativeOperations operations = new IterativeOperations(createSampleTree());
    operations.printPreOrder(operations.getNode());
    System.out.println();
    operations.preorder(operations.getNode());
  }
}
