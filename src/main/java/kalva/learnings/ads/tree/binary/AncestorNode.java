package kalva.learnings.ads.tree.binary;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class AncestorNode {
    public static void main(String[] args) {
        List<Node> a1 = new ArrayList<>();
        List<Node> a2 = new ArrayList<>();
        List<Node> a3 = new ArrayList<>();

        isAncestor(randomData(), 9, a1);
        isAncestor(randomData(), 10, a2);
        isAncestor(randomData(), 1, a3);

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
    }

    private static boolean isAncestor(Node node, Integer data, List<Node> a1) {
        if (null == node) {
            return false;
        }
        if (node.data == data) {
            a1.add(node);
            return true;
        }

        if (isAncestor(node.left, data, a1) || isAncestor(node.right, data, a1)) {
            a1.add(node);
            return true;
        }
        return false;
    }

    /**
     * <pre>
     *                     1
     *                   /   \
     *                 2      3
     *               /  \       \
     *             4     5      6
     *           /   \         /   \
     *         7      8     9     10
     * </pre>
     */
    private static Node randomData() {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);

        root.left.left.left = new Node(7);
        root.left.left.right = new Node(8);

        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);
        return root;
    }

    private static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return valueOf(data);
        }
    }
}
