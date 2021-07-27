package kalva.learnings.ads.tree.binary;

import java.util.Objects;

import static kalva.learnings.ads.Node.createSampleTree;
import static kalva.learnings.ads.Node.findNode;
import static kalva.learnings.ads.Node.leftMostNode;
import static kalva.learnings.ads.Node.rightMostNode;

import kalva.learnings.ads.Node;

public class Predecessor {

  static Node found = null;

  public static void main(String[] args) {
    RecursiveOperations operations = new RecursiveOperations(createSampleTree());
    operations.inOrder();
    System.out.println();
    System.out.println("1 = " + inorderPredecessor(createSampleTree(), 1));
    resetData();
    System.out.println("3 = " + inorderPredecessor(createSampleTree(), 3));
    resetData();
    System.out.println("8 = " + inorderPredecessor(createSampleTree(), 8));
    resetData();
    System.out.println("6 = " + inorderPredecessor(createSampleTree(), 6));
    resetData();
    System.out.println("10 = " + inorderPredecessor(createSampleTree(), 10));
  }

  private static void resetData() {
    found = null;
  }

  /**
   * @param rootNode
   * @param value
   * @return
   */
  private static int inorderPredecessor(Node rootNode, int value) {

    Node temp = null;
    Node searchNode = findNode(rootNode, value);

    //Case-1: if it has, rigt most of the left node
    if (null != searchNode.getLeft()) {
      temp = rightMostNode(searchNode.getLeft());
    } else {
      //Case-2: If it is leftmost then there is no predecessor
      temp = leftMostNode(rootNode);
      if (value == temp.getData()) {
        return -1;
      }
      inorderPredecessorWhenLeftIsNull(rootNode, value);
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

  private static Node inorderPredecessorWhenLeftIsNull(Node root, int value) {
    if (null == root) {
      return null;
    }
    if (Objects.equals(root.getData(), value)) {
      return root;
    }
    Node temp;
    if (null == (temp = inorderPredecessorWhenLeftIsNull(root.getLeft(), value)) &&
        null == (temp = inorderPredecessorWhenLeftIsNull(root.getRight(), value))) {
      return null;
    }
    if (Objects.equals(root.getRight().getData(), temp.getData())) {
      if (null == found) {
        found = root;
      }
    }
    return root;
  }
}
