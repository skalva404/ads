package kalva.learnings.ads.tree;

import java.util.Objects;

public class TreeNode {

  private TreeNode left;
  private TreeNode right;
  private Integer data;

  private TreeNode(Integer data) {
    this.data = data;
  }

  private TreeNode(Integer data, TreeNode left, TreeNode right) {
    this.left = left;
    this.right = right;
    this.data = data;
  }

  public TreeNode getLeft() {
    return left;
  }

  public TreeNode getRight() {
    return right;
  }

  public Integer getData() {
    return data;
  }

  /**
   * *                            1
   * *                      2         3
   * *                   4    5   6     7
   * *                  8 9           10 11
   */
  public static TreeNode createSampleTree() {
    return new TreeNode(1,
        new TreeNode(2,
            new TreeNode(4, new TreeNode(8), new TreeNode(9)),
            new TreeNode(5)),
        new TreeNode(3,
            new TreeNode(6),
            new TreeNode(7, new TreeNode(10), new TreeNode(11))));
  }

  public static TreeNode leftMostNode(TreeNode searchNode) {
    TreeNode temp = searchNode.getLeft();
    while (null != temp && null != temp.getLeft()) {
      temp = temp.getLeft();
    }
    return temp;
  }

  public static TreeNode rightMostNode(TreeNode searchNode) {
    TreeNode temp = searchNode.getRight();
    if (null == temp) {
      return searchNode;
    }
    while (null != temp && null != temp.getRight()) {
      temp = temp.getRight();
    }
    return temp;
  }

  public static TreeNode findNode(TreeNode root, Integer value) {
    if (null == root) {
      return null;
    }
    if (Objects.equals(root.getData(), value)) {
      return root;
    }
    TreeNode temp;
    if (null == (temp = findNode(root.getLeft(), value)) &&
        null == (temp = findNode(root.getRight(), value))) {
      return null;
    }
    return temp;
  }

  @Override
  public String toString() {
    return "TreeNode{" + data + '}';
  }
}
