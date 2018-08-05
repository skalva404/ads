package kalva.learnings.ads.tree.binary;

import static java.lang.String.*;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {

  public static void main(String[] args) {
    List<Node> list = new ArrayList<>();
    rootToNode(randomData(), 10, list);
    System.out.println(list);
  }

  static boolean rootToNode(Node root, int data, List<Node> path) {
    if (null == root) {
      return false;
    }
    if (data == root.data) {
      return true;
    }
    boolean left = rootToNode(root.left, data, path);
    boolean right = rootToNode(root.right, data, path);
    if (left) {
      path.add(root);
      return true;
    }
    if (right) {
      path.add(root);
      return true;
    }
    return false;
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
