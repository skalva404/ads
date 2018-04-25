package kalva.learnings.ads.tree.binary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kalva.learnings.ads.tree.Node;

public class NodesBwTwoGivenLevels {

  public static void main(String[] args) {
    Node root = new Node(5);
    root.left = new Node(10);
    root.right = new Node(15);
    root.left.left = new Node(20);
    root.left.right = new Node(25);
    root.right.left = new Node(30);
    root.right.right = new Node(35);
    root.left.right.left = new Node(40);
    root.left.right.right = new Node(45);
    root.left.right.left.left = new Node(50);
    Map<Integer, List<Node>> nodes = new HashMap<>();
    for (int i = 2; i <= 4; i++) {
      nodesBwTwoGivenLevels(root, i, 1, nodes);
    }
    nodes.forEach((key, values) -> System.out.println(key + "==>" + values));
  }

  private static void nodesBwTwoGivenLevels(Node root, int tLevel, int cLevel,
                                            Map<Integer, List<Node>> nodes) {
    if (null == root) {
      return;
    }
    if (tLevel == cLevel) {
      nodes.computeIfAbsent(cLevel, key -> new ArrayList<>());
      nodes.get(cLevel).add(root);
    }
    nodesBwTwoGivenLevels(root.getLeft(), tLevel, cLevel + 1, nodes);
    nodesBwTwoGivenLevels(root.getRight(), tLevel, cLevel + 1, nodes);
  }
}
