package kalva.learnings.ads.tree.binary;

import static java.lang.String.*;

public class DistanceFromTwoNodes {

  public static void main(String[] args) {
    Node root = randomData();
    int d1 = distance(root, 7);
    int d2 = distance(root, 9);
    int lca = distance(root, lca(root, 7, 9).data);

    System.out.println(d1 + d2 - (2 * lca));
  }

  static int distance(Node root, int d) {
    if (null == root) {
      return 0;
    }
    if (d == root.data) {
      return 1;
    }
    int left = distance(root.left, d);
    int right = distance(root.right, d);
    if (0 < left) {
      return ++left;
    }
    if (0 < right) {
      return ++right;
    }
    return 0;
  }

  static Node lca(Node root, int x, int y) {
    if (null == root) {
      return null;
    }
    if (root.data == x || root.data == y) {
      return root;
    }
    Node l = lca(root.left, x, y);
    Node r = lca(root.right, x, y);
    if (null == l && null == r) {
      return null;
    }
    if (null != l && null != r) {
      return root;
    }
    return (null == l) ? r : l;
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
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return valueOf(data);
    }
  }
}
