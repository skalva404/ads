package kalva.learnings.ads.tree.binary;

import java.util.Objects;

import kalva.learnings.ads.Node;

public class KAncestor {

  static int k = 3;

  public static void main(String[] args) {
    kAncestor(Node.createSampleTree(), 9);
    ancestor(Node.createSampleTree(), 9);
  }

  private static boolean ancestor(Node root, int value) {
    if (null == root) {
      return false;
    }
    if (Objects.equals(value, root.getData())) {
      return true;
    }
    if (ancestor(root.getLeft(), value) || ancestor(root.getRight(), value)) {
      System.out.print(root.getData() + "\t");
      return true;
    }
    return false;
  }

  private static Node kAncestor(Node root, int value) {
    if (null == root) {
      return null;
    }
    if (Objects.equals(root.getData(), value) ||
        null != kAncestor(root.getLeft(), value) ||
        null != kAncestor(root.getRight(), value)) {
      if (k > 0) {
        k--;
      } else if (0 == k) {
        System.out.println(String.format("KAncestor of %s => %s", value, root.getData()));
        return null;
      }
      return root;
    }
    return null;
  }
}
