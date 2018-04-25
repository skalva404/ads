package kalva.learnings.ads.tree.binary;

import kalva.learnings.ads.tree.Node;

public class SizeOfTree {

  public static void main(String[] args) {
    System.out.println(sizeOf(Node.createSampleTree()));
  }
  private static int sizeOf(Node root) {
    if (null == root) {
      return 0;
    }
    return 1 + sizeOf(root.getRight()) + sizeOf(root.getLeft());
  }
}
