package kalva.learnings.ads.tree.binary;

import java.util.Stack;

import static kalva.learnings.ads.tree.TreeNode.createSampleTree;

import kalva.learnings.ads.tree.TreeNode;

public class BasicIterativeOperations {

  private TreeNode node;

  public BasicIterativeOperations(TreeNode node) {
    this.node = node;
  }

  public void printPreOrder() {
    printPreOrder(node);
  }

  private void printPreOrder(TreeNode root) {
    if (null == root) {
      return;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
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
    BasicIterativeOperations operations = new BasicIterativeOperations(createSampleTree());
    operations.printPreOrder();
  }
}
