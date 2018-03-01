package kalva.learnings.ads.tree;

public class TreeNode {

  private TreeNode left;
  private TreeNode right;
  private Integer data;

  public TreeNode(Integer data) {
    this.data = data;
  }

  public TreeNode(Integer data, TreeNode left, TreeNode right) {
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

  public void setLeft(TreeNode left) {
    this.left = left;
  }

  public void setRight(TreeNode right) {
    this.right = right;
  }

  public Integer getData() {
    return data;
  }

  /**
   * *                        1
   * *                     2     3
   * *                   4  5  6  7
   */
  public static TreeNode createSampleTree() {
    return new TreeNode(1,
        new TreeNode(2, new TreeNode(4), new TreeNode(5)),
        new TreeNode(3, new TreeNode(6), new TreeNode(7)));
  }
}
