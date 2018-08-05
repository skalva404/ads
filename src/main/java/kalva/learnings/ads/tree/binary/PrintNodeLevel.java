package kalva.learnings.ads.tree.binary;

import static java.lang.String.*;

public class PrintNodeLevel {

  public static void main(String[] args) {
    System.out.println(getLevel(randomData(), 4, 1));
  }

  static int getLevel(Node node, int data, int level) {
    if (null == node) {
      return 0;
    }

    if (data == node.data) {
      return level;
    }

    int leftLevel = getLevel(node.left, data, level + 1);
    if (0 < leftLevel) {
      return leftLevel;
    }

    return getLevel(node.right, data, level + 1);
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
