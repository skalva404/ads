package kalva.learnings.ads.tree.binary;

import static java.lang.String.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateSubTree {

  public static void main(String[] args) {
    Node node = randomData();
    List<Integer> data = new ArrayList<>();
    inOrder(node, data);
    System.out.println(data);
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < data.size(); i++) {
      Integer item = data.get(i);
      map.computeIfAbsent(item, it -> new ArrayList<>()).add(i);
    }
    System.out.println(map);
  }

  static void inOrder(Node root, List<Integer> inOrder) {
    if (null == root) {
      return;
    }
    inOrder(root.left, inOrder);
    inOrder.add(root.data);
    inOrder(root.right, inOrder);
  }

  /**
   * <pre>
   *                     1
   *                   /   \
   *                 2      3
   *               /  \       \
   *             4     5      2
   *                          /  \
   *                        4     6
   * </pre>
   */
  private static Node randomData() {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);

    root.left.left = new Node(4);
    root.left.right = new Node(5);

    root.right.right = new Node(2);

    root.right.right.left = new Node(4);
    root.right.right.right = new Node(5);
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
