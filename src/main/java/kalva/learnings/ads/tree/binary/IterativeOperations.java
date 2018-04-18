package kalva.learnings.ads.tree.binary;

import java.util.Stack;

import static kalva.learnings.ads.tree.Node.createSampleTree;

import kalva.learnings.ads.tree.Node;

public class IterativeOperations {

  private Node node;

  public IterativeOperations(Node node) {
    this.node = node;
  }

  public Node getNode() {
    return node;
  }

  void preorder(Node node) {
    if (node != null) {
      System.out.print(node.getData() + "\t");
      preorder(node.getLeft());
      preorder(node.getRight());
    }
  }

  private void printPreOrder(Node root) {
    if (null == root) {
      return;
    }
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    while (!stack.empty()) {
      Node pop = stack.pop();
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
