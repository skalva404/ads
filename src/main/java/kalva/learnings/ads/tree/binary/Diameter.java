package kalva.learnings.ads.tree.binary;

import java.util.List;

import kalva.learnings.ads.tree.TreeNode;

public class Diameter {

  public static void main(String[] args) {
    TreeNode node = TreeNode.createSampleTree();
    List<Integer> leftPath = TreeNode.find(node, TreeNode.leftMostNode(node));
    List<Integer> rightPath = TreeNode.find(node, TreeNode.rightMostNode(node));
    assert leftPath != null;
    assert rightPath != null;
    System.out.println(leftPath.size() + rightPath.size() + 1);
  }
}
