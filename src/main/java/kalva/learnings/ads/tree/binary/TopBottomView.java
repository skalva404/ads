package kalva.learnings.ads.tree.binary;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import kalva.learnings.ads.Utils;
import kalva.learnings.ads.Node;

public class TopBottomView {

  public static void main(String[] args) {
    Map<Integer, Integer> bottom = new HashMap<>();
    Node sampleTree = createSampleTree();
    for (int i = 1; i <= Utils.height(sampleTree); i++) {
      bottomView(sampleTree, 1, bottom, i, 1);
    }
    System.out.println(bottom.values());

    Map<Integer, Integer> top = new HashMap<>();
    Node topTree = createSampleTree();
    for (int i = 1; i <= Utils.height(topTree); i++) {
      topView(topTree, 1, top, i, 1);
    }
    System.out.println(top.values());
  }

  private static void bottomView(Node root, int level, Map<Integer, Integer> view,
                                 Integer targetLevel, Integer currentLevel) {
    if (null == root) {
      return;
    }
    if (Objects.equals(targetLevel, currentLevel)) {
      view.put(level, root.data);
      return;
    }
    bottomView(root.getLeft(), level + 1, view, targetLevel, currentLevel + 1);
    bottomView(root.getRight(), level - 1, view, targetLevel, currentLevel + 1);
  }

  private static void topView(Node root, int level, Map<Integer, Integer> view,
                              Integer targetLevel, Integer currentLevel) {
    if (null == root) {
      return;
    }
    if (Objects.equals(targetLevel, currentLevel) && null == view.get(level)) {
      view.put(level, root.data);
      return;
    }
    topView(root.getLeft(), level + 1, view, targetLevel, currentLevel + 1);
    topView(root.getRight(), level - 1, view, targetLevel, currentLevel + 1);
  }

  public static Node createSampleTree() {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.left.left = new Node(8);
    root.left.left.right = new Node(9);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    return root;
  }
}
