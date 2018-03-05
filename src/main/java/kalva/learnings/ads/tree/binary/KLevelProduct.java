package kalva.learnings.ads.tree.binary;

/**
 * Given an integer ‘K’ and a binary tree in string format. Every node of a tree has value in range from 0 to 9.
 * We need to find product of elements at K-th level from root. The root is at level 0.
 * Note : Tree is given in the form: (node value(left subtree)(right subtree))
 * <p>
 * nput : tree = "(0(5(6()())(4()(9()())))(7(1()())(3()())))"
 * k = 2
 * Output : 72
 * Its tree representation is shown below
 * *                0
 * *         5           7
 * *     6     4      1    3
 * *             9
 */
public class KLevelProduct {

  public static void main(String[] args) {
    String tree = "(0(5(6()())(4()(9()())))(7(1()())(3()())))";
    int k = 2;
    System.out.println(product(tree, k));
  }

  private static long product(String tree, int k) {
    long product = 1;
    int level = -1;
    for (int i = 0; i < tree.length(); i++) {
      if ("(".equals(tree.charAt(i) + "")) {
        level++;
      } else if (")".equals(tree.charAt(i) + "")) {
        level--;
      } else if (level == k) {
        product = product * Integer.parseInt(tree.charAt(i) + "");
      }
    }
    return product;
  }
}
