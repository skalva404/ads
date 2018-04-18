package kalva.learnings.ads.backtracking;

import kalva.learnings.ads.tree.Node;

/**
 * https://algorithms.tutorialhorizon.com/print-paths-in-binary-tree-with-sumx/
 */
public class SumPath {

  public static void main(String[] args) {
    sumPath(Node.createSampleTree(), 8, "");
  }

  private static void sumPath(Node root, Integer sum, String path) {
    if (null == root) {
      return;
    }
    if (root.getData() > sum) {
      return;
    }
    path += " " + root.getData();
    sum -= root.getData();
    if (0 == sum) {
      System.out.println(path);
    }
    sumPath(root.getLeft(), sum, path);
    sumPath(root.getRight(), sum, path);
  }
}
