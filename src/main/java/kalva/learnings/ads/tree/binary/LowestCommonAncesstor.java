package kalva.learnings.ads.tree.binary;

import static java.lang.String.*;

public class LowestCommonAncesstor {

  static Node lca(Node root, int n1, int n2) {
    if (null == root) {
      return null;
    }
    if (root.data == n1 || root.data == n2) {
      return root;
    }
    Node left = lca(root.left, n1, n2);
    Node right = lca(root.right, n1, n2);

    if (null == left && null == right) {
      return null;
    }
    if (null != left && null != right) {
      return root;
    }
    return (null == left) ? right : left;
  }

  public static void main(String[] args) {
    System.out.println(1 == lca(randomData(), 7, 10).data);
//    System.out.println(2 == lca(randomData(), 7, 5).data);
//    System.out.println(1 == lca(randomData(), 7, 6).data);
//    System.out.println(4 == lca(randomData(), 7, 4).data);
  }

  /**
   * <pre>
   *                     1
   *                   /   \
   *                 2      3
   *               /  \       \
   *             4     5      6
   *           /   \         /   \
   *         7      8     9     10
   * </pre>
   */
  private static Node randomData() {
    Node root = new Node(1);

    root.left = new Node(2);
    root.right = new Node(3);

    root.left.left = new Node(4);
    root.left.right = new Node(5);

    root.right.right = new Node(6);

    root.left.left.left = new Node(7);
    root.left.left.right = new Node(8);

    root.right.right.left = new Node(9);
    root.right.right.right = new Node(10);
    return root;
  }

  private static class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return valueOf(data);
    }
  }
}
