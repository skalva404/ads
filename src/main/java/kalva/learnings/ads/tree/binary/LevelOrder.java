package kalva.learnings.ads.tree.binary;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import static kalva.learnings.ads.tree.TreeNode.createSampleTree;

import kalva.learnings.ads.tree.TreeNode;

public class LevelOrder {

  public static void main(String[] args) {
    printLevelOrder(createSampleTree());
    System.out.println();
    printLevelOrderRecursive(createSampleTree());

    System.out.println();
    System.out.println();
    printZigZagOrder(createSampleTree());
    System.out.println();
    printZigZagOrderRecursive(createSampleTree());
  }

  private static void printZigZagOrder(TreeNode node) {

    Stack<TreeNode> ltor = new Stack<>();
    Stack<TreeNode> rtol = new Stack<>();
    ltor.add(node);

    while (true) {
      if (ltor.isEmpty()) {
        return;
      }
      while (!ltor.isEmpty()) {
        TreeNode poll = ltor.pop();
        System.out.print(poll.getData() + "\t");
        if (null != poll.getRight()) {
          rtol.add(poll.getRight());
        }
        if (null != poll.getLeft()) {
          rtol.add(poll.getLeft());
        }
      }

      if (rtol.isEmpty()) {
        return;
      }
      while (!rtol.isEmpty()) {
        TreeNode pop = rtol.pop();
        System.out.print(pop.getData() + "\t");
        if (null != pop.getLeft()) {
          ltor.add(pop.getLeft());
        }
        if (null != pop.getRight()) {
          ltor.add(pop.getRight());
        }
      }
    }
  }

  private static void printLevelOrder(TreeNode node) {
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(node);
    while (!queue.isEmpty()) {
      TreeNode poll = queue.poll();
      System.out.print(poll.getData() + "\t");
      if (null != poll.getLeft()) {
        queue.add(poll.getLeft());
      }
      if (null != poll.getRight()) {
        queue.add(poll.getRight());
      }
    }
  }

  private static void printZigZagOrderRecursive(TreeNode node) {
    int counter = 0;
    int height = Utils.height(node);
    for (int i = 1; i <= height; i++) {
      printZigZagOrderRecursive(node, i, counter++);
    }
  }

  private static void printZigZagOrderRecursive(TreeNode node, int d, int ctr) {
    if (null == node) {
      return;
    }
    if (1 == d) {
      System.out.print(node.getData() + "\t");
    } else {
      if (0 != ctr % 2) {
        printZigZagOrderRecursive(node.getLeft(), d - 1, ctr);
        printZigZagOrderRecursive(node.getRight(), d - 1, ctr);
      } else {
        printZigZagOrderRecursive(node.getRight(), d - 1, ctr);
        printZigZagOrderRecursive(node.getLeft(), d - 1, ctr);
      }
    }
  }

  private static void printLevelOrderRecursive(TreeNode node) {
    int height = Utils.height(node);
    for (int i = 1; i <= height; i++) {
      printLevelOrderRecursive(node, i);
    }
  }

  private static void printLevelOrderRecursive(TreeNode node, int d) {
    if (null == node) {
      return;
    }
    if (1 == d) {
      System.out.print(node.getData() + "\t");
    } else {
      printLevelOrderRecursive(node.getLeft(), d - 1);
      printLevelOrderRecursive(node.getRight(), d - 1);
    }
  }
}
