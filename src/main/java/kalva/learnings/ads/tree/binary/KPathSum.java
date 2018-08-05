package kalva.learnings.ads.tree.binary;

import static java.lang.String.*;

import java.util.ArrayList;
import java.util.List;

public class KPathSum {

  public static void main(String[] args) {
    List<List<Integer>> paths = new ArrayList<>();
//    ksumPaths(randomData(), 5, new ArrayList<>(), paths);
//    System.out.println(paths);

    paths = new ArrayList<>();
    kSumPathFromRoot(randomData(), 6, new ArrayList<>(), paths);
    System.out.println(paths);

//    List<Integer> path = new ArrayList<>();
//    printSSumPath(randomData(), 6, 0, path);
//    System.out.println(path);
  }

  static void printSSumPath(Node root, int s, int sofar, List<Integer> path) {
    if (null == root) {
      return;
    }

    sofar += root.data;
    path.add(root.data);

    printSSumPath(root.left, s, sofar, path);
    printSSumPath(root.right, s, sofar, path);

    if (s == sofar) {
      for (Integer ig : path) {
        System.out.print(ig + " ");
      }
      System.out.println();
    }

    path.remove(path.size() - 1);
  }

  private static void kSumPathFromRoot(Node root, int k, List<Integer> data, List<List<Integer>> paths) {

    if (null == root) {
      return;
    }

    data.add(root.data);
    kSumPathFromRoot(root.left, k, data, paths);
    kSumPathFromRoot(root.right, k, data, paths);

    if (k == data.stream().mapToInt(i -> i).sum()) {
      List<Integer> path = new ArrayList<>(data);
      paths.add(path);
    }
    data.remove(data.size() - 1);
  }

  static void ksumPaths(Node root, int k, List<Integer> data, List<List<Integer>> paths) {

    if (null == root) {
      return;
    }

    data.add(root.data);
    ksumPaths(root.left, k, data, paths);
    ksumPaths(root.right, k, data, paths);

    int localSum = 0;
    for (int i = data.size() - 1; i >= 0; i--) {
      localSum += data.get(i);
      if (k == localSum) {
        List<Integer> path = new ArrayList<>();
        paths.add(path);
        for (int j = i; j < data.size(); j++) {
          path.add(data.get(j));
          System.out.print(data.get(j) + " ");
        }
        System.out.println();
      }
    }
    data.remove(data.size() - 1);
  }

  /**
   * <pre>
   *                    1
   *                 /     \
   *               3        -1
   *             /  \      /   \
   *           2    1    4     5
   *                 /   / \     \
   *                1  1   2     6
   * </pre>
   */
  private static Node randomData() {
    Node root = new Node(1);

    root.left = new Node(3);
    root.right = new Node(-1);

    root.left.left = new Node(2);
    root.left.right = new Node(1);

    root.right.left = new Node(4);
    root.right.right = new Node(5);

    root.left.right.left = new Node(1);//asd

    root.right.left.left = new Node(1);
    root.right.left.right = new Node(2);

    root.right.right.right = new Node(6);
    return root;
  }

  private static class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return valueOf(data);
    }
  }

}
