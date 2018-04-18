package kalva.learnings.ads.tree.binary;

import kalva.learnings.ads.tree.Node;

public class MaxSumPathBetweenLeaves {

  private static int result = 0;
  private static String pathToLeaf = "";
  private static int sum;

  private static void findMaxSumToLeaf(Node root, int localSum, String path) {
    if (null == root) {
      return;
    }
    localSum += root.getData();
    path += " " + root.getData();
    if (localSum > sum) {
      pathToLeaf = path;
      sum = localSum;
    }
    findMaxSumToLeaf(root.getLeft(), localSum, path);
    findMaxSumToLeaf(root.getRight(), localSum, path);
  }

  private static int sumPathLeafNodes(Node root) {
    if (null == root) {
      return 0;
    }
    if (null == root.getLeft() && null == root.getRight()) {
      return root.getData();
    }

    int ls = sumPathLeafNodes(root.left);
    int rs = sumPathLeafNodes(root.right);
    if (null != root.getLeft() && null != root.getRight()) {
      result = Math.max(result, root.data + ls + rs);
      return Math.max(ls, rs) + root.data;
    }
    return root.getData() + (null == root.getLeft() ? rs : ls);
  }

  public static void main(String[] args) {
//    findMaxSumToLeaf(createSampleTree(), 0, "");
//    System.out.println(sum);
//    System.out.println(pathToLeaf);
    sumPathLeafNodes(createSampleTree());
    System.out.println(result);
  }

  public static Node createSampleTree() {
    Node root = new Node(-15);
    root.left = newNode(5);
    root.right = newNode(6);
    root.left.left = newNode(-8);
    root.left.right = newNode(1);
    root.left.left.left = newNode(2);
    root.left.left.right = newNode(6);
    root.right.left = newNode(3);
    root.right.right = newNode(9);
    root.right.right.right = newNode(0);
    root.right.right.right.left = newNode(4);
    root.right.right.right.right = newNode(-1);
    root.right.right.right.right.left = newNode(10);
    return root;
  }

  private static Node newNode(int i) {
    return new Node(i);
  }
}
