package kalva.learnings.ads.tree.binary;

import java.util.HashMap;
import java.util.Map;

import kalva.learnings.ads.Utils;
import kalva.learnings.ads.tree.Node;

public class VerticleSum {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    Map<Integer, Integer> vSum = new HashMap<>();
    vSum(root, vSum, 0);
    System.out.println(vSum);
  }

  private static void vSum(Node root, Map<Integer, Integer> vSum, int tLevel) {
    for (int i = 1; i <= Utils.height(root); i++) {
      vSumUtil(root, vSum, 1, i, 1);
    }
  }

  private static void vSumUtil(Node root, Map<Integer, Integer> vSum, int level, int tLevel, int cLevel) {
    if (null == root) {
      return;
    }
    if (cLevel == tLevel) {
      vSum.putIfAbsent(level, 0);
      vSum.put(level, vSum.get(level) + root.getData());
    }
    vSumUtil(root.getLeft(), vSum, level + 1, tLevel, cLevel + 1);
    vSumUtil(root.getRight(), vSum, level - 1, tLevel, cLevel + 1);
  }
}
