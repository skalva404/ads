package kalva.learnings.ads.tree.binary;

import java.util.Objects;

import static kalva.learnings.ads.tree.Node.createSampleTree;
import static kalva.learnings.ads.tree.Node.findNode;
import static kalva.learnings.ads.tree.Node.leftMostNode;
import static kalva.learnings.ads.tree.Node.rightMostNode;

import kalva.learnings.ads.tree.Node;

/**
 * We need to take care of 3 cases for any node to find its inorder successor as described below:
 * <p>
 * Right child of node is not NULL. If the right child of the node is not NULL then the inorder successor of this node will
 * be the leftmost node in it’s right subtree.
 * Right Child of the node is NULL. If the right child of node is NULL. Then we keep finding the parent of the given node x,
 * say p such that p->left = x. For example in the above given tree, inorder successor of node 5 will be 1.
 * First parent of 5 is 2 but 2->left != 5. So next parent of 2 is 1, now 1->left = 2. Therefore, inorder successor of 5 is 1.
 * Below is the algorithm for this case:
 * Suppose the given node is x. Start traversing the tree from root node to find x recursively.
 * If root == x, stop recursion otherwise find x recursively for left and right subtrees.
 * Now after finding the node x, recur­sion will back­track to the root. Every recursive call will return the node itself to the calling function,
 * we will store this in a temporary node say temp.Now, when it back­tracked to its par­ent which will be root now,
 * check whether root.left = temp, if not , keep going up
 * .
 * <p>
 * If node is the rightmost node. If the node is the rightmost node in the given tree. For example,
 * in the above tree node 6 is the right most node. In this case, there will be no inorder successor of this node. i.e.
 * Inorder Successor of the rightmost node in a tree is NULL.
 */
public class Successor {

  static Node found;

  public static void main(String[] args) {

    RecursiveOperations operations = new RecursiveOperations(createSampleTree());
    operations.inOrder();
    System.out.println();
    resetData();
    System.out.println("3 = " + inorderSuccessor(createSampleTree(), 3));
    resetData();
    System.out.println("5 = " + inorderSuccessor(createSampleTree(), 5));
    resetData();
    System.out.println("11 = " + inorderSuccessor(createSampleTree(), 11));
    resetData();
    System.out.println("8 = " + inorderSuccessor(createSampleTree(), 8));
  }

  private static void resetData() {
    found = null;
  }

  private static int inorderSuccessor(Node rootNode, int value) {
    Node temp;
    Node searchNode = findNode(rootNode, value);
    if (null != searchNode.getRight()) {
      temp = leftMostNode(searchNode.getRight());
    } else {
      temp = rightMostNode(rootNode);
      if (value == temp.getData()) {
        return -1;
      }
      inorderSuccessorWhenRightIsNull(rootNode, searchNode.getData());
      if (null != found) {
        return found.getData();
      }
      return -1;
    }
    if (null != temp) {
      return temp.getData();
    }
    return -1;
  }

  private static Node inorderSuccessorWhenRightIsNull(Node root, int value) {
    if (null == root) {
      return null;
    }
    if (Objects.equals(root.getData(), value)) {
      return root;
    }

    Node temp;
    if (null == (temp = inorderSuccessorWhenRightIsNull(root.getLeft(), value)) &&
        (null == (temp = inorderSuccessorWhenRightIsNull(root.getRight(), value)))) {
      return null;
    }
    if (null != root.getLeft() &&
        Objects.equals(root.getLeft().getData(), temp.getData())) {
      if (null == found) {
        found = root;
      }
    }
    return root;
  }
}

