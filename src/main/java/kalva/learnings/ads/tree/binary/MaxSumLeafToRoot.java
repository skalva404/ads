package kalva.learnings.ads.tree.binary;

import java.util.ArrayList;
import java.util.List;

import kalva.learnings.ads.Node;

public class MaxSumLeafToRoot {

  static Node maxLeaf = null;
  static int maxSum = Integer.MIN_VALUE;

  static List<Integer> path = new ArrayList<>();

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.left.left = new Node(8);

//    root = Node.createSampleTree();
    maxSumLeafToRoot(root, 0);
    path(root, maxLeaf.data);
    System.out.println(maxSum);
    System.out.println(path);
  }

  private static Node path(Node root, int dest) {
    if (null == root) {
      return null;
    }
    if (dest == root.getData() ||
        null != path(root.getLeft(), dest) ||
        null != path(root.getRight(), dest)) {
      path.add(root.getData());
      return root;
    }
//    Node left = path(root.getLeft(), dest);
//    if (null != left) {
//      path.add(root.getData());
//      return left;
//    }
//    Node right = path(root.getRight(), dest);
//    if (null != right) {
//      path.add(root.getData());
//      return right;
//    }
    return null;
  }

  private static int maxSumLeafToRoot(Node root, int cSum) {
    if (null == root) {
      return 0;
    }
    cSum += root.data;
    if (maxSum < cSum &&
        null == root.getLeft() && null == root.getRight()) {
      maxLeaf = root;
      maxSum = cSum;
    }
    maxSumLeafToRoot(root.getLeft(), cSum);
    maxSumLeafToRoot(root.getRight(), cSum);
    return cSum;
  }
}
