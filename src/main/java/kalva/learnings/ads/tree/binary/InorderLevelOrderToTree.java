package kalva.learnings.ads.tree.binary;

import kalva.learnings.ads.Node;

public class InorderLevelOrderToTree {

  private static int[] leveloder = new int[]{1, 2, 3, 4, 5, 6, 7};

  public static void main(String[] args) {
    Node node = constructBinaryTree(leveloder, new int[]{4, 2, 5, 1, 6, 3, 7}, 0, leveloder.length - 1);
    assert node != null;
    node.printBFS();
  }

  private static Node constructBinaryTree(int[] levelOrder, int[] inOrder, int s, int e) {
    if (s > e) {
      return null;
    }
    if (s == e) {
      return new Node(inOrder[s]);
    }
    int index = findIndex(levelOrder, inOrder, s, e);
    Node node = new Node(inOrder[index]);
    node.setLeft(constructBinaryTree(levelOrder, inOrder, s, index - 1));
    node.setRight(constructBinaryTree(levelOrder, inOrder, index + 1, e));
    return node;
  }

  private static int findIndex(int[] levelOrder, int[] inOrder, int s, int e) {
    for (int lo : levelOrder) {
      for (int i = s; i <= e; i++) {
        int anInOrder = inOrder[i];
        if (lo == anInOrder) {
          return i;
        }
      }
    }
    return -1;
  }
}
