package kalva.learnings.ads.tree.binary;

import kalva.learnings.ads.tree.Node;

public class InorderDFStoTree {

  private static int indexCounter = 0;

  public static void main(String[] args) {
    Node node = inorderDFStoTree(
        new int[]{1, 2, 4, 8, 5, 3, 6, 7, 9}, //dfs
        new int[]{8, 4, 2, 5, 1, 6, 3, 7, 9}, //io
        0, 8);
    assert node != null;
    node.printBFS();
  }

  private static Node inorderDFStoTree(int[] dfsOrder, int[] inOrder, int s, int e) {
    if (s > e) {
      return null;
    }
    Node root = new Node(dfsOrder[indexCounter++]);
    if (s == e) {
      return root;
    }
    int index = findIndex(inOrder, root.data, s, e);
    root.setLeft(inorderDFStoTree(dfsOrder, inOrder, s, index - 1));
    root.setRight(inorderDFStoTree(dfsOrder, inOrder, index + 1, e));
    return root;
  }

  private static int findIndex(int[] inOrder, int search, int s, int e) {
    for (int i = s; i <= e; i++) {
      int anInOrder = inOrder[i];
      if (search == anInOrder) {
        return i;
      }
    }
    return -1;
  }
}
