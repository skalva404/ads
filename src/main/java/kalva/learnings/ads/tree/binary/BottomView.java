package kalva.learnings.ads.tree.binary;

import static java.lang.String.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class BottomView {

  public static void main(String[] args) {
    bootomViewIterative(randomData());

    System.out.println();
    HashMap<Integer, Node> map = new HashMap<>();
    bootomViewRecussive(randomData(), 0, map);
    System.out.println(map.values());
  }

  static void bootomViewRecussive(Node root, int level, Map<Integer, Node> levelMap) {
    if (null == root) {
      return;
    }
    levelMap.put(level, root);

    bootomViewRecussive(root.left, level + 1, levelMap);
    bootomViewRecussive(root.right, level - 1, levelMap);
  }

  static void bootomViewIterative(Node root) {

    Queue<Node> queue = new LinkedList<>();
    Map<Integer, Node> levelMap = new TreeMap<>();

    queue.add(root);
    root.hd = 0;
    int hd;

    while (!queue.isEmpty()) {

      Node deQueued = queue.remove();
      levelMap.put(deQueued.hd, deQueued);
      hd = deQueued.hd;

      if (null != deQueued.left) {
        deQueued.left.hd = hd - 1;
        queue.add(deQueued.left);
      }

      if (null != deQueued.right) {
        deQueued.right.hd = hd + 1;
        queue.add(deQueued.right);
      }
    }

    // Extract the entries of map into a set to traverse
    // an iterator over that.
    Set<Map.Entry<Integer, Node>> set = levelMap.entrySet();

    // Make an iterator
    Iterator<Map.Entry<Integer, Node>> iterator = set.iterator();

    // Traverse the map elements using the iterator.
    while (iterator.hasNext()) {
      Map.Entry<Integer, Node> me = iterator.next();
      System.out.print(me.getValue() + " ");
    }
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
    int hd = Integer.MAX_VALUE;

    public Node(int data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return valueOf(data);
    }
  }
}
