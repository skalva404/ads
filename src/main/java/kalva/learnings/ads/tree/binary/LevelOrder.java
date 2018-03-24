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
    boolean directionflag = false;
    Stack<TreeNode> stack = new Stack<>();
    stack.add(node);
    while (!stack.empty()) {
      Stack<TreeNode> tempStack = new Stack<>();
      while (!stack.empty()) {
        TreeNode pop = stack.pop();
        System.out.print(pop.getData() + "\t");
        if (directionflag) {
          if (null != pop.getLeft()) {
            tempStack.push(pop.getLeft());
          }
          if (null != pop.getRight()) {
            tempStack.push(pop.getRight());
          }
        } else {
          if (null != pop.getRight()) {
            tempStack.push(pop.getRight());
          }
          if (null != pop.getLeft()) {
            tempStack.push(pop.getLeft());
          }
        }
      }
      directionflag = !directionflag;
      stack = tempStack;
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

  private static void printZigZagOrderRecursive(TreeNode root) {
    int counter = 0;
    int height = Utils.height(root);
    for (int i = 1; i <= height; i++) {
      printZigZagOrderRecursive(root, i, counter++);
    }
  }

  private static void printZigZagOrderRecursive(TreeNode node, int d, int ctr) {

    if (null == node) {
      return;
    }
    if (1 == d) {
      System.out.print(node.getData() + "\t");
    }
    if (0 != ctr % 2) {
      printZigZagOrderRecursive(node.getLeft(), d - 1, ctr);
      printZigZagOrderRecursive(node.getRight(), d - 1, ctr);
    } else {
      printZigZagOrderRecursive(node.getRight(), d - 1, ctr);
      printZigZagOrderRecursive(node.getLeft(), d - 1, ctr);
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
