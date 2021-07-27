package kalva.learnings.ads.tree.binary;

import kalva.learnings.ads.Utils;
import kalva.learnings.ads.Node;

public class MirrorAlternatives {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    root.left.left.left = new Node(8);
    root.left.left.right = new Node(9);
    root.left.right.left = new Node(10);
    root.left.right.right = new Node(11);

    root.right.left.left = new Node(12);
    root.right.left.right = new Node(13);
    root.right.right.left = new Node(14);
    root.right.right.right = new Node(15);

    root.printBFS();
    for (int i = 0; i < Utils.height(root); i++) {
      if (0 == i % 2) {
        mirror(root, i, 0);
      }
    }
    for (int i = 0; i < Utils.height(root); i++) {
      if (0 != i % 2) {
        mirror(root, i, 0);
      }
    }
    System.out.println();
    root.printBFS();
  }

  private static void mirror(Node node, int tLevel, int cLevel) {
    if (null == node) {
      return;
    }

    if (tLevel == cLevel) {
      Node temp = node.getLeft();
      node.setLeft(node.getRight());
      node.setRight(temp);

      temp = node.getLeft().getLeft();
      node.getLeft().setLeft(node.getRight().getRight());
      node.getRight().setRight(temp);
    }
    mirror(node.getLeft(), tLevel, cLevel + 1);
    mirror(node.getRight(), tLevel, cLevel + 1);
  }
}
