package kalva.learnings.ads.tree.binary

import java.lang.Math.max

import kalva.learnings.ads.tree.Node

object MaxElement extends App {

  println(maxNode(Node.createSampleTree()))

  def maxNode(root: Node): Int = {
    if (null == root) {
      return 0
    }
    max(root.getData, max(maxNode(root.getLeft), maxNode(root.getRight)))
  }
}