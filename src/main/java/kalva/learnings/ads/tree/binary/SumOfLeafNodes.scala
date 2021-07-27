package kalva.learnings.ads.tree.binary

import kalva.learnings.ads.Node

object SumOfLeafNodes extends App {

  def sum(root: Node): Integer = {
    if (null == root) {
      return 0
    }
    if (null == root.getLeft && null == root.getRight) {
      return root.getData
    }
    sum(root.getLeft) + sum(root.getRight)
  }

  println(sum(Node.createSampleTree()))
}
