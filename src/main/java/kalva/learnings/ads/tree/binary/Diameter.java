package kalva.learnings.ads.tree.binary;

import java.util.List;

import kalva.learnings.ads.Node;

public class Diameter {

  public static void main(String[] args) {
    Node node = Node.createSampleTree();
    List<Integer> leftPath = Node.find(node, Node.leftMostNode(node));
    List<Integer> rightPath = Node.find(node, Node.rightMostNode(node));
    assert leftPath != null;
    assert rightPath != null;
    System.out.println(leftPath.size() + rightPath.size() + 1);
  }
}
