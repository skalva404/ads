package kalva.learnings.ads.tree.binary;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import static kalva.learnings.ads.tree.Node.createSampleTree;

import kalva.learnings.ads.Utils;
import kalva.learnings.ads.tree.Node;

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

  private static void printZigZagOrder(Node node) {
    boolean directionflag = false;
    Stack<Node> stack = new Stack<>();
    stack.add(node);
    while (!stack.empty()) {
      Stack<Node> tempStack = new Stack<>();
      while (!stack.empty()) {
        Node pop = stack.pop();
        System.out.print(pop + "\t");
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
      System.out.println();
    }
  }

  private static void printLevelOrder(Node node) {
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(node);
    while (!queue.isEmpty()) {
      Node poll = queue.poll();
      System.out.print(poll.getData() + "\t");
      if (null != poll.getLeft()) {
        queue.add(poll.getLeft());
      }
      if (null != poll.getRight()) {
        queue.add(poll.getRight());
      }
    }
  }

  private static void printZigZagOrderRecursive(Node root) {
    int counter = 0;
    int height = Utils.height(root);
    for (int i = 1; i <= height; i++) {
      printZigZagOrderRecursive(root, i, counter++);
    }
  }

  private static void printZigZagOrderRecursive(Node node, int d, int ctr) {

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

  private static void printLevelOrderRecursive(Node node) {
    int height = Utils.height(node);
    for (int i = 1; i <= height; i++) {
      printLevelOrderRecursive(node, i);
    }
  }

  private static void printLevelOrderRecursive(Node node, int d) {
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
