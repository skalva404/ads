package kalva.learnings.ads.tree.binary;

import kalva.learnings.ads.Node;

/**
 * * https://algorithms.tutorialhorizon.com/find-whether-if-a-given-binary-tree-is-balanced/
 * *                            5
 * *                      10         15
 * *                   20   25    30    35
 * *                                       40
 * *                                          45
 **/
public class BalancedTree {

  public static void main(String[] args) {
    Node root = new Node(5);
    root.left = new Node(10);
    root.right = new Node(15);
    root.left.left = new Node(20);
    root.left.right = new Node(25);
    root.right.left = new Node(30);
    root.right.right = new Node(35);
    System.out.println(" Is Tree Balanced : " + (isBalanced(root) > 0));
    root.right.right.right = new Node(40);
    root.right.right.right.right = new Node(45);
    System.out.println(" Is Tree Balanced : " + (isBalanced(root) > 0));
  }

  private static int isBalanced(Node root) {
    if (null == root) {
      return 0;
    }
    int l = isBalanced(root.getLeft());
    int r = isBalanced(root.getRight());
    if (-1 == l || -1 == r) {
      return -1;
    }
    if (1 < Math.abs(l - r)) {
      return -1;
    }
    return 1 + Math.max(l, r);
  }
}
