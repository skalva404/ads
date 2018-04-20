package kalva.learnings.ads.tree.binary;

import kalva.learnings.ads.tree.Node;

public class MSumBtwnLeaves {

  static int total = 0;
  private static int sum;
  private static String pathToLeaf = "";

  public static void main(String[] args) {
    mSumBtwnLeaves(Node.createSampleTree());
    System.out.println(total);
    findMaxSumToLeaf(Node.createSampleTree(), 0, "");
    System.out.println(pathToLeaf + " => " + sum);
  }

  private static void findMaxSumToLeaf(Node root, int localSum, String path) {
    if (null == root) {
      return;
    }
    localSum += root.getData();
    path += root.data + " ";
    if (localSum > sum) {
      sum = localSum;
      pathToLeaf = path;
    }
    findMaxSumToLeaf(root.getLeft(), localSum, path);
    findMaxSumToLeaf(root.getRight(), localSum, path);
  }

  private static int mSumBtwnLeaves(Node root) {
    if (null == root) {
      return 0;
    }
    if (null == root.getLeft() && null == root.getLeft()) {
      return root.getData();
    }
    int l = mSumBtwnLeaves(root.getLeft());
    int r = mSumBtwnLeaves(root.getRight());
    if (null != root.getLeft() && null != root.getRight()) {
      total = Math.max(total, root.data + l + r);
      return root.getData() + Math.max(l, r);
    }
    return root.getData() +
        (null != root.getLeft() ? root.getLeft().getData() : root.getRight().getData());
  }
}
