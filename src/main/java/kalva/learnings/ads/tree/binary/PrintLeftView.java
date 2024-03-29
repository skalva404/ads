package kalva.learnings.ads.tree.binary;

import java.util.HashMap;
import java.util.Map;

import kalva.learnings.ads.Utils;
import kalva.learnings.ads.Node;

/**
 *https://algorithms.tutorialhorizon.com/print-left-view-of-a-given-binary-tree/
 */
public class PrintLeftView {

  public static void main(String[] args) {
    Node root = new Node(5);
    root.left = new Node(10);
    root.right = new Node(15);
    root.left.left = new Node(20);
    root.left.right = new Node(25);
    root.right.left = new Node(30);
    root.right.right = new Node(35);
    root.left.right.right = new Node(45);

    Map<Integer, Node> lvMap = new HashMap<>();
    for (int i = 0; i < Utils.height(root); i++) {
      printLeftView(root, lvMap, i, 0);
    }
    System.out.println(lvMap);
  }

  private static void printLeftView(Node root, Map<Integer, Node> lvMap, int tLevel, int cLevel) {
    if (null == root) {
      return;
    }
    if (tLevel == cLevel && null == lvMap.get(tLevel)) {
      lvMap.put(tLevel, root);
    }
    printLeftView(root.getLeft(), lvMap, tLevel, cLevel + 1);
    printLeftView(root.getRight(), lvMap, tLevel, cLevel + 1);
  }
}
