package kalva.learnings.ads.tree.bst;

import kalva.learnings.ads.Node;

public class BST {

    private Node insert(Node root, Integer value) {

        if (null == root) {
            return new Node(value);
        }

        if (value < root.getData()) {
            Node insert = insert(root.getLeft(), value);
            root.setLeft(insert);
        }
        if (value > root.getData()) {
            Node insert = insert(root.getRight(), value);
            root.setRight(insert);
        }
        return root;
    }

    public Node delete(Node root, Integer value) {
        if (null == root) {
            return null;
        }
        if (value > root.getData()) {
            Node delete = delete(root.getRight(), value);
            root.setRight(delete);
        } else if (value < root.getData()) {
            Node delete = delete(root.getLeft(), value);
            root.setLeft(delete);
        } else {
            if (null == root.getLeft() && null == root.getRight()) {
                return null;
            } else if (null != root.getLeft() && null != root.getRight()) {

                Node leftMostNode = Node.leftMostNode(root.getRight());
                root.setData(leftMostNode.getData());

                Node delete = delete(root.getRight(), leftMostNode.getData());
                root.setRight(delete);
            } else {
                if (null == root.getLeft()) {
                    return root.getRight();
                } else if (null == root.getRight()) {
                    return root.getLeft();
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {

        BST bst = new BST();
        Node root = new Node(50);
        bst.insert(root, 30);
        bst.insert(root, 70);
        bst.insert(root, 20);
        bst.insert(root, 40);
        bst.insert(root, 60);
        bst.insert(root, 80);
        root.printInOrder();

        bst.delete(root, 20);
        root.printInOrder();

        bst.delete(root, 80);
        root.printInOrder();

        bst.delete(root, 50);
        root.printInOrder();
    }
}
