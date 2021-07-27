package kalva.learnings.ads.tree.binary;

import kalva.learnings.ads.Node;

import static kalva.learnings.ads.Node.createSampleTree;

public class RecursiveOperations {

    private Node node;

    public RecursiveOperations(Node node) {
        this.node = node;
    }

    public void inOrder() {
        inOrder(node);
    }

    public void printPreOrder() {
        printPreOrder(node);
    }

    private void inOrder(Node root) {
        if (null == root) {
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root.getData() + "\t");
        inOrder(root.getRight());
    }

    private void printPreOrder(Node root) {
        if (null == root) {
            return;
        }
        System.out.print(root.getData() + "\t");
        printPreOrder(root.getLeft());
        printPreOrder(root.getRight());
    }

    public static void main(String[] args) {
        RecursiveOperations operations = new RecursiveOperations(createSampleTree());
    }
}
