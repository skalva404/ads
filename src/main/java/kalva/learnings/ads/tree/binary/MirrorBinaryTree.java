package kalva.learnings.ads.tree.binary;

import static java.lang.String.*;

public class MirrorBinaryTree {

  public static void main(String[] args) {
    Node node = randomData();
    inOrder(node);
    mirror(node);
    System.out.println();
    inOrder(node);
  }

  static void mirror(Node node) {
    if (null == node) {
      return;
    }
    Node temp = node.left;
    node.left = node.right;
    node.right = temp;
    mirror(node.left);
    mirror(node.right);
  }

  static void inOrder(Node root) {
    if (null == root) {
      return;
    }
    inOrder(root.left);
    System.out.print(root.data + "\t");
    inOrder(root.right);
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
