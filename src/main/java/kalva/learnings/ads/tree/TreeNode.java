package kalva.learnings.ads.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static kalva.learnings.ads.Utils.print;

import kalva.learnings.ads.Utils;

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

  public void setData(Integer data) {
    this.data = data;
  }

  public TreeNode getLeft() {
    return left;
  }

  public void setLeft(TreeNode left) {
    this.left = left;
  }

  public void setRight(TreeNode right) {
    this.right = right;
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

  private static TreeNode leftMost(TreeNode searchNode) {
    if (null == searchNode) {
      return null;
    }
    TreeNode treeNode = leftMost(searchNode.getLeft());
    if (null == treeNode) {
      return searchNode;
    }
    return treeNode;
  }

  public static TreeNode leftMostNode(TreeNode searchNode) {
    TreeNode temp = searchNode;
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

  public static List<Integer> find(TreeNode root, TreeNode node) {
    if (Objects.equals(root.getData(), node.getData())) {
      return new ArrayList<>();
    }
    List<Integer> result;
    if (root.left != null) {
      result = find(root.left, node);
      if (result != null) {
        result.add(0, root.getData());
        return result;
      }
    }
    if (root.right != null) {
      result = find(root.right, node);
      if (result != null) {
        result.add(0, root.getData());
        return result;
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return "TreeNode{" + data + '}';
  }

  public void printInOrder() {
    _printInOrder(this);
  }

  public void printBFS() {
    for (int i = 1; i <= Utils.height(this); i++) {
      _printBFS(this, i, 1);
    }
  }

  private void _printBFS(TreeNode node, int level, int currentLevel) {
    if (null == node) {
      return;
    }
    if (level == currentLevel && null != node.data) {
      print(node.data);
      return;
    }
    _printBFS(node.getLeft(), level, currentLevel + 1);
    _printBFS(node.getRight(), level, currentLevel + 1);
  }

  private void _printInOrder(TreeNode node) {
    if (null == node) {
      return;
    }
    _printInOrder(node.getLeft());
    System.out.print(node.getData() + "\t");
    _printInOrder(node.getRight());
  }

  public static void main(String[] args) {
    TreeNode sampleTree = TreeNode.createSampleTree();
    System.out.println(TreeNode.leftMost(sampleTree));
    System.out.println(TreeNode.leftMostNode(sampleTree));
//    System.out.println(find(sampleTree, new TreeNode(10, null, null)));
  }
}
