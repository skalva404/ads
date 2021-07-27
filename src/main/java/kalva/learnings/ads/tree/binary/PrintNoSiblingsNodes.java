package kalva.learnings.ads.tree.binary;

import kalva.learnings.ads.Node;

public class PrintNoSiblingsNodes {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.left.right.left = new Node(7);
    root.left.left.left = new Node(6);
    root.right.right = new Node(8);
    root.right.right.left = new Node(9);
    printNoSiblingsNodes(root);
  }

  private static void printNoSiblingsNodes(Node root) {
    if (null == root) {
      return;
    }
    printNoSiblingsNodes(root.getLeft());
    if (null != root.getLeft() && null == root.getRight()) {
      System.out.print(root.getLeft() + "\t");
    }
    if (null != root.getRight() && null == root.getLeft()) {
      System.out.print(root.getRight() + "\t");
    }
    printNoSiblingsNodes(root.getRight());
  }
}
