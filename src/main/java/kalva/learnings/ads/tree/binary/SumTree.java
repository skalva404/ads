package kalva.learnings.ads.tree.binary;

import kalva.learnings.ads.tree.Node;

/**
 * https://algorithms.tutorialhorizon.com/convert-binary-tree-to-its-sum-tree/
 */
public class SumTree {

  private static Node sampleTree = Node.createSampleTree();

  private static int findSum(Node node) {
    if (null == node) {
      return 0;
    }
    int leftSum = findSum(node.getLeft());
    int rightSum = findSum(node.getRight());
    int rootDate = node.getData() + leftSum + rightSum;
    node.setData(leftSum + rightSum);
    return rootDate;
  }

  public static void main(String[] args) {
    sampleTree.printBFS();
    findSum(sampleTree);
    System.out.println();
    sampleTree.printBFS();
  }
}
