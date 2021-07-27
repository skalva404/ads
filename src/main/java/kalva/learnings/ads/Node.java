package kalva.learnings.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {

    public Node left;
    public Node right;
    public Node sibling;
    public Integer data;

    public Node(Integer data) {
        this.data = data;
    }

    public Node(Integer data, Node left, Node right) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getRight() {
        return right;
    }

    public Integer getData() {
        return data;
    }

    public Node getSibling() {
        return sibling;
    }

    public void setSibling(Node sibling) {
        this.sibling = sibling;
    }

    /**
     * *                            1
     * *                      2         3
     * *                   4    5   6     7
     * *                  8 9           10 11
     */
    public static Node createSampleTree() {
        return new Node(1,
                new Node(2,
                        new Node(4, new Node(8), new Node(9)),
                        new Node(5)),
                new Node(3,
                        new Node(6),
                        new Node(7, new Node(10), new Node(11))));
    }

    private static Node leftMost(Node searchNode) {
        if (null == searchNode) {
            return null;
        }
        Node node = leftMost(searchNode.getLeft());
        if (null == node) {
            return searchNode;
        }
        return node;
    }

    public static Node leftMostNode(Node searchNode) {
        Node temp = searchNode;
        while (null != temp && null != temp.getLeft()) {
            temp = temp.getLeft();
        }
        return temp;
    }

    public static Node rightMostNode(Node searchNode) {
        Node temp = searchNode.getRight();
        while (null != temp && null != temp.getRight()) {
            temp = temp.getRight();
        }
        return temp;
    }

    public static Node findNode(Node root, Integer value) {
        if (null == root) {
            return null;
        }
        if (Objects.equals(root.getData(), value)) {
            return root;
        }
        Node temp;
        if (null == (temp = findNode(root.getLeft(), value)) &&
                null == (temp = findNode(root.getRight(), value))) {
            return null;
        }
        return temp;
    }

    public static List<Integer> find(Node root, Node node) {
        if (Objects.equals(root.getData(), node.getData())) {
            return new ArrayList<>();
        }
        List<Integer> result;
        if (root.left != null) {
            result = find(root.left, node);
            if (result != null) {
                result.add(0, root.getData());
                return result;
            }
        }
        if (root.right != null) {
            result = find(root.right, node);
            if (result != null) {
                result.add(0, root.getData());
                return result;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "{" + data +
                ((null != sibling) ? " -> " + sibling.data : "")
                + '}';
    }

    public void printInOrder() {
        _printInOrder(this);
        System.out.println();
    }

    public void printBFS() {
        for (int i = 1; i <= Utils.height(this); i++) {
            _printBFS(this, i, 1);
        }
    }

    private void _printBFS(Node node, int level, int currentLevel) {
        if (null == node) {
            return;
        }
        if (level == currentLevel && null != node.data) {
            System.out.print(node + "  ");
            return;
        }
        _printBFS(node.getLeft(), level, currentLevel + 1);
        _printBFS(node.getRight(), level, currentLevel + 1);
    }

    private void _printInOrder(Node node) {
        if (null == node) {
            return;
        }
        _printInOrder(node.getLeft());
        System.out.print(node.getData() + "\t");
        _printInOrder(node.getRight());
    }

    public static void printFullNode(Node root) {
        if (null == root) {
            return;
        }
        if (null != root.getLeft() && null != root.getRight()) {
            System.out.print(root.data + "\t");
        }
        printFullNode(root.getLeft());
        printFullNode(root.getRight());
    }

    public static void main(String[] args) {
        Node sampleTree = Node.createSampleTree();
        printFullNode(sampleTree);
//    System.out.println(Node.leftMost(sampleTree));
//    System.out.println(Node.leftMostNode(sampleTree));
//    System.out.println(find(sampleTree, new Node(10, null, null)));
    }
}
