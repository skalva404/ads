package kalva.learnings.ads.tree.binary;

import static java.lang.String.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {

  public static void main(String[] args) {

    HashMap<Integer, Node> map = new HashMap<>();
    topViewRecurssive(randomData(), 0, map);
    System.out.println(map.values());

    topViewIterative(randomData());
  }

  static void topViewIterative(Node root) {
    Queue<Node> queue = new LinkedList<>();
    Map<Integer, Node> levelMap = new TreeMap<>();
    queue.add(root);
    int hd = 0;
    root.hd = hd;
    while (!queue.isEmpty()) {
      Node remove = queue.remove();
      levelMap.computeIfAbsent(remove.hd, integer -> {
        System.out.print(remove.data + ", ");
        return remove;
      });
      hd = remove.hd;
      levelMap.put(remove.hd, remove);
      if (null != remove.left) {
        remove.left.hd = hd + 1;
        queue.add(remove.left);
      }
      if (null != remove.right) {
        remove.right.hd = hd - 1;
        queue.add(remove.right);
      }
    }
  }

  static void topViewRecurssive(Node root, int level, Map<Integer, Node> levelMap) {
    if (null == root) {
      return;
    }
    if (null != root.left) {
      topViewRecurssive(root.left, level - 1, levelMap);
    }
    if (null != root.right) {
      topViewRecurssive(root.right, level + 1, levelMap);
    }
    levelMap.put(level, root);
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
    Integer hd;

    public Node(int data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return valueOf(data);
    }
  }
}
