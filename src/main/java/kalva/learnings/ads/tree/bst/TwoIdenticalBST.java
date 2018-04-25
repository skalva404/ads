package kalva.learnings.ads.tree.bst;

import java.util.Objects;

import kalva.learnings.ads.tree.Node;

public class TwoIdenticalBST {

  public static void main(String[] args) {
    BST a = new BST().insert(2).insert(4).insert(1).insert(3).insert(5);
    BST b = new BST().insertR(2).insertR(4).insertR(1).insertR(3).insertR(5);
    a.root.printBFS();
    System.out.println();
    b.root.printBFS();

    System.out.println();
    System.out.println(isIdentical(a.root, b.root));

    BST c = new BST().insert(2).insert(4).insert(1).insert(3).insert(51);
    System.out.println();
    c.root.printBFS();
    System.out.println();
    System.out.println(isIdentical(a.root, c.root));
  }

  private static boolean isIdentical(Node that, Node thiz) {
    return
        null == that && null == thiz || null != that && null != thiz
            && Objects.equals(thiz.data, that.data)
            && isIdentical(that.getLeft(), thiz.getLeft())
            && isIdentical(that.getRight(), thiz.getRight());
  }

  private static class BST {
    public Node root = null;

    BST insertR(int value) {
      if (root == null) {
        root = new Node(value);
      } else {
        _insertR(root, value);
      }
      return this;
    }

    Node _insertR(Node node, int value) {
      if (null == node) {
        return new Node(value);
      }
      if (value > node.getData()) {
        node.setRight(_insertR(node.getRight(), value));
      } else if (value < node.getData()) {
        node.setLeft(_insertR(node.getLeft(), value));
      }
      return node;
    }

    BST insert(int value) {
      Node node = new Node(value);
      if (null == root) {
        root = node;
        return this;
      }
      Node temp = root;
      while (true) {
        if (value > temp.getData()) {
          if (null == temp.getRight()) {
            temp.setRight(node);
            return this;
          }
          temp = temp.getRight();
        } else {
          if (null == temp.getLeft()) {
            temp.setLeft(node);
            return this;
          }
          temp = temp.getLeft();
        }
      }
    }
  }
}
