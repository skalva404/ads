package kalva.learnings.ads.tree.binary;

import static java.lang.String.*;

public class LRView {

  static int max = 0;

  public static void main(String[] args) {
    max = 0;
    printRightView(randomData(), 1);
    System.out.println("========");
    max = 0;
    printLeftView(randomData(), 1);
  }

  private static void printLeftView(Node node, int level) {

    if (null == node) {
      return;
    }
    if (max < level) {
      max = level;
      System.out.println(node.data);
    }
    printLeftView(node.left, level + 1);
    printLeftView(node.right, level + 1);
  }

  private static void printRightView(Node node, int level) {

    if (null == node) {
      return;
    }
    if (max < level) {
      max = level;
      System.out.println(node.data);
    }
    printRightView(node.right, level + 1);
    printRightView(node.left, level + 1);
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
