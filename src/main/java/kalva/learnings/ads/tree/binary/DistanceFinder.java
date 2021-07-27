package kalva.learnings.ads.tree.binary;

import java.util.ArrayList;
import java.util.List;

import kalva.learnings.ads.Node;
import kalva.learnings.ads.Utils;

public class DistanceFinder {

  private static List<Integer> kDistanceFromLeaf = new ArrayList<>();
  private static List<Integer> kDistanceFromroot = new ArrayList<>();

  private static void kDistanceNodesFromLeaf(Node root, int k, int height, int currentLevel) {
    if (null == root) {
      return;
    }
    if (currentLevel == height - k - 1) {
      kDistanceFromLeaf.add(root.data);
    }
    kDistanceNodesFromLeaf(root.getLeft(), k, height, currentLevel + 1);
    kDistanceNodesFromLeaf(root.getRight(), k, height, currentLevel + 1);
  }

  private static void kDistanceNodesFromRoot(Node root, int k, int currentLevel) {
    if (null == root) {
      return;
    }
    if (currentLevel == k) {
      kDistanceFromroot.add(root.data);
    }
    kDistanceNodesFromRoot(root.getLeft(), k, currentLevel + 1);
    kDistanceNodesFromRoot(root.getRight(), k, currentLevel + 1);
  }

  private static int distance(Node root, int n1, int n2) {
    int p1 = distance(root, n1) - 1;
    int p2 = distance(root, n2) - 1;
    int lca = 2 * (distance(root, lca(root, n1, n2).data) - 1);
    return p1 + p2 - lca;
  }

  private static Node lca(Node root, int n1, int n2) {
    if (null == root) {
      return null;
    }
    if (root.data == n1 || root.data == n2) {
      return root;
    }
    Node l = lca(root.getLeft(), n1, n2);
    Node r = lca(root.getRight(), n1, n2);
    if (null != l && null != r) {
      return root;
    }
    return null != r ? r : l;
  }

  private static int distance(Node root, int key) {
    if (null == root) {
      return 0;
    }
    if (key == root.getData()) {
      return 1;
    }
    int l = distance(root.getLeft(), key);
    if (1 <= l) {
      return 1 + l;
    }
    int r = distance(root.getRight(), key);
    if (1 <= r) {
      return 1 + r;
    }
    return 0;
  }

  public static void main(String[] args) {
    kDistanceNodesFromLeaf(Node.createSampleTree(), 1, Utils.height(Node.createSampleTree()), 0);
//    kDistanceNodesFromRoot(Node.createSampleTree(), 3, 1);
//    System.out.println(kDistanceFromLeaf);
//    System.out.println(kDistanceFromroot);
    System.out.println(distance(Node.createSampleTree(), 8, 11));
  }
}
