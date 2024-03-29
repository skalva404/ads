package kalva.learnings.ads.tree.binary;

import kalva.learnings.ads.Node;

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

  private static int sumPathLeafNodes(Node node) {
    if (null == node) {
      return 0;
    }
    if (null == node.getLeft() && null == node.getRight()) {
      return node.getData();
    }
    int ls = sumPathLeafNodes(node.getLeft());
    int rs = sumPathLeafNodes(node.getRight());
    if (null != node.getLeft() && null != node.getRight()) {
      result = Math.max(result, node.data + ls + rs);
      return node.data + Math.max(ls, rs);
    }
    return node.getData() + (null != node.getLeft() ? node.getLeft().data : node.getRight().data);
  }

  public static void main(String[] args) {
//    findMaxSumToLeaf(createSampleTree(), 0, "");
//    System.out.println(sum);
//    System.out.println(pathToLeaf);
    sumPathLeafNodes(createSampleTree()); //24
    System.out.println(result);
  }

  public static Node createSampleTree() {
    Node root = new Node(-5);
    root.left = new Node(1);
    root.right = new Node(4);
    root.left.left = new Node(-6);
    root.left.right = new Node(5);
    root.left.right.left = new Node(-2);
    root.left.right.right = new Node(3);
    root.left.left.left = new Node(9);
    root.left.left.right = new Node(10);
    root.right.left = new Node(11);
    root.right.right = new Node(-2);
    root.right.right.right = new Node(-8);
    root.right.right.left = new Node(7);
    root.right.right.right.left = new Node(1);
    root.right.right.right.right = new Node(7);
    root.right.right.right.right.left = new Node(12);
    return Node.createSampleTree();
//    return root;
  }

  private static Node newNode(int i) {
    return new Node(i);
  }
}
