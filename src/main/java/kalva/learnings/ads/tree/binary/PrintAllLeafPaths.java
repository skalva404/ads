package kalva.learnings.ads.tree.binary;

import kalva.learnings.ads.tree.Node;

public class PrintAllLeafPaths {

  public static void main(String[] args) {
    printAllLeafPaths(Node.createSampleTree(), "");
  }

  private static void printAllLeafPaths(Node root, String path) {
    if (null == root) {
      return;
    }
    path += root.getData() + " ";
    if (null == root.getLeft() && null == root.getLeft()) {
      System.out.println(path);
    }
    printAllLeafPaths(root.getLeft(), path);
    printAllLeafPaths(root.getRight(), path);
  }
}
