package kalva.learnings.ads.tree.binary;

import static java.lang.String.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Height {

  public static void main(String[] args) {
    System.out.println(height(randomData()));
    Map<Integer, List<Integer>> map = new HashMap<>();
    verticalHeight(randomData(), 1, map);
    System.out.println(map);
  }

  static void verticalHeight(Node root, int level, Map<Integer, List<Integer>> map) {
    if (null == root) {
      return;
    }
    map.computeIfAbsent(level, l -> new ArrayList<>()).add(root.data);
    verticalHeight(root.left, level - 1, map);
    verticalHeight(root.right, level + 1, map);
  }

  static int height(Node root) {
    if (null == root) {
      return 0;
    }
    return 1 + Math.max(height(root.left), height(root.right));
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
