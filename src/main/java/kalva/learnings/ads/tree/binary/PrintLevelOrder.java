package kalva.learnings.ads.tree.binary;

import static java.lang.String.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintLevelOrder {

  public static void main(String[] args) {
    printLevelOrder(randomData());
    System.out.println("");
    printZigZagOrder(randomData());
  }

  static void printZigZagOrder(Node root) {
    Stack<Node> lr = new Stack<>();
    Stack<Node> rl = new Stack<>();
    lr.push(root);

    while (lr.size() > 0 || rl.size() > 0) {
      while (!lr.empty()) {
        Node pop = lr.pop();
        System.out.print(pop.data + "\t");
        if (null != pop.left) {
          rl.push(pop.left);
        }
        if (null != pop.right) {
          rl.push(pop.right);
        }
      }
      System.out.println();
      while (!rl.empty()) {
        Node pop = rl.pop();
        System.out.print(pop.data + "\t");
        if (null != pop.right) {
          lr.push(pop.right);
        }
        if (null != pop.left) {
          lr.push(pop.left);
        }
      }
      System.out.println();
    }
  }

  static void printLevelOrder(Node node) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    while (queue.size() > 0) {
      Node remove = queue.remove();
      System.out.print(remove.data + "\t");
      if (null != remove.left) {
        queue.add(remove.left);
      }
      if (null != remove.right) {
        queue.add(remove.right);
      }
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
