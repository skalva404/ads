package kalva.learnings.ads.tree.binary;

import static java.lang.String.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LevelView {

  public static void main(String[] args) {
    levelView(randomData());
    Map<Integer, List<Integer>> levelMap = new HashMap<>();
    levelViewRecurssive(randomData(), 1, levelMap);
    System.out.println(levelMap);
  }

  static void levelViewRecurssive(Node root, int level, Map<Integer, List<Integer>> levelMap) {
    if (null == root) {
      return;
    }
    levelMap.computeIfAbsent(level, l -> new ArrayList<>()).add(root.data);
    levelViewRecurssive(root.left, level + 1, levelMap);
    levelViewRecurssive(root.right, level + 1, levelMap);
  }

  static void levelView(Node root) {
    List<Node> l1 = new ArrayList<>();
    List<Node> l2 = new ArrayList<>();

    l1.add(root);

    while (!l1.isEmpty()) {
      Iterator<Node> iterator = l1.iterator();
      while (iterator.hasNext()) {
        Node next = iterator.next();
        System.out.print(next.data + "\t");
        if (null != next.left) {
          l2.add(next.left);
        }
        if (null != next.right) {
          l2.add(next.right);
        }
        iterator.remove();
      }
      System.out.println();
      l1.addAll(l2);
      l2 = new ArrayList<>();
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

    public Node(int data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return valueOf(data);
    }
  }
}
