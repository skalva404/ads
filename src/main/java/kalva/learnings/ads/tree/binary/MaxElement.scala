package kalva.learnings.ads.tree.binary

import java.lang.Math.max

import kalva.learnings.ads.tree.TreeNode

object MaxElement extends App {

  println(maxNode(TreeNode.createSampleTree()))

  def maxNode(root: TreeNode): Int = {
    if (null == root) {
      return 0
    }
    max(root.getData, max(maxNode(root.getLeft), maxNode(root.getRight)))
  }
}